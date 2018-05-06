package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;

/**
 * 
 * @Description 商品管理接口
 * @author 席春光
 * @date 2018年2月25日
 *
 */
public interface ItemService {
	TbItem getTbItemById(Long id);
	EasyUIDataGridResult getItemList(int page,int rows);
	E3Result addItem(TbItem item, String desc);
	E3Result deleteItems(Long[] ids);
	E3Result updateItems(Long[] ids,TbItem item);
}
