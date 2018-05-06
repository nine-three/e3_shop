package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.mapper.TbItemParamItemMapper;
import cn.e3mall.pojo.TbItemParamItem;
import cn.e3mall.pojo.TbItemParamItemExample;
import cn.e3mall.service.ItemParameItemService;
/**
 * 
 * @Description 商品规格类
 * @author 席春光
 * @date 2018年2月25日
 *
 */
@Service
public class ItemParameItemServiceImpl implements ItemParameItemService {
	
	@Autowired
	private TbItemParamItemMapper tbItemParamItemMapper;


	@Override
	public E3Result getTbItemParameItem(Long itemId) {
		TbItemParamItemExample example = new TbItemParamItemExample();
		cn.e3mall.pojo.TbItemParamItemExample.Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		List<TbItemParamItem> itemParamItems = tbItemParamItemMapper.selectByExample(example);
		if(itemParamItems != null && itemParamItems.size() > 0) {
			return E3Result.ok(itemParamItems.get(0));
		}else {
			return null;
		}
	}
}
