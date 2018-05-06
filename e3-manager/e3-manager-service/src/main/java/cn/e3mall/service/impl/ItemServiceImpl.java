package cn.e3mall.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.common.utils.IDUtils;
import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.ItemService;
/**
 * 
 * @Description 商品管理类
 * @author 席春光
 * @date 2018年2月25日
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Override
	public TbItem getTbItemById(Long id) {
		
		TbItem item = null;
		//直接根据主键查询
		//TbItem item = itemMapper.selectByPrimaryKey(id);
		//根据条件查询
		TbItemExample itemExample = new TbItemExample();
		Criteria criteria = itemExample.createCriteria();
		criteria.andIdEqualTo(id);
		List<TbItem> itemList = itemMapper.selectByExample(itemExample);
		if(itemList != null && itemList.size() > 0) {
			item =  itemList.get(0);
		}
		
		return item;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//查询数据
		TbItemExample itemExample = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(itemExample);
		//创建返回值对象
		EasyUIDataGridResult dataGridResult = new EasyUIDataGridResult();
		//取分页数据
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		
		dataGridResult.setTotal(pageInfo.getTotal());
		dataGridResult.setRows(pageInfo.getList());
		
		return dataGridResult;
	}

	@Override
	public E3Result addItem(TbItem item, String desc) {
		// 1、生成商品id
		long itemId = IDUtils.genItemId();
		// 2、补全TbItem对象的属性
		item.setId(itemId);
		//商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		// 3、向商品表插入数据
		itemMapper.insert(item);
		// 4、创建一个TbItemDesc对象
		TbItemDesc itemDesc = new TbItemDesc();
		// 5、补全TbItemDesc的属性
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		// 6、向商品描述表插入数据
		itemDescMapper.insert(itemDesc);
		// 7、E3Result.ok()
		return E3Result.ok();

	}

	@Override
	public E3Result deleteItems(Long[] ids) {
		for (long itemId : ids) {
			itemMapper.deleteByPrimaryKey(itemId);
		}
		return E3Result.ok();
	}

	@Override
	public E3Result updateItems(Long[] ids,TbItem item) {
		
		item.setUpdated(new Date());
		
		for (Long itemId : ids) {
			TbItemExample example = new TbItemExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(itemId);
			itemMapper.updateByExampleSelective(item, example);
		}
		return E3Result.ok();
	}
	
}
