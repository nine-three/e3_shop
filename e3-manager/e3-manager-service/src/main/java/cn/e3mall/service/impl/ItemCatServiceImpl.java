package cn.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.service.ItemCatService;
/**
 * item分类管理
 * @Description TODO
 * @author 席春光
 * @date 2018年3月7日
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		TbItemCatExample itemCatExample = new TbItemCatExample();
		Criteria criteria = itemCatExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(itemCatExample);
		List<EasyUITreeNode> result = new ArrayList<>();
		for (TbItemCat itemCat : list) {
			EasyUITreeNode treeNode = new EasyUITreeNode();
			treeNode.setId(itemCat.getId());
			treeNode.setText(itemCat.getName());
			treeNode.setState(itemCat.getIsParent()?"closed":"open");
			result.add(treeNode);
		}
		return result;
	}

}
