package cn.e3mall.service;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;
/**
 * 
 * @Description 商品分类接口
 * @author 席春光
 * @date 2018年4月12日
 *
 */
public interface ItemCatService {
	public List<EasyUITreeNode> getItemCatList(long parentId);
}
