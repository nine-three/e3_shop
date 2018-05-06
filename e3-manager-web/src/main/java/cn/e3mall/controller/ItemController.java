package cn.e3mall.controller;
/**
 * 
 * @Description 商品管理controller
 * @author 席春光
 * @date 2018年2月25日
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemDescService;
import cn.e3mall.service.ItemParameItemService;
import cn.e3mall.service.ItemService;
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemDescService itemDescService;
	@Autowired
	private ItemParameItemService itemParameItemService;
	
	
	@RequestMapping(value="/item/{itemId}",method=RequestMethod.GET)
	@ResponseBody
	public TbItem geTbItemById(@PathVariable Long itemId) {
		TbItem item = itemService.getTbItemById(itemId);
		return item;
	}
	
	@RequestMapping(value="/item/list",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult getbItemById(int page,int rows) {
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public E3Result saveTbItem(TbItem item,String desc) {
		E3Result e3Result = itemService.addItem(item, desc);
		return e3Result;
	}
	@RequestMapping(value="/rest/item/query/item/desc/{itemId}",method=RequestMethod.GET)
	@ResponseBody
	public E3Result getTbItemDesc(@PathVariable Long itemId) {
		E3Result e3Result = itemDescService.getTbItemDescById(itemId);
		return e3Result;
	}
	@RequestMapping(value="/rest/item/param/item/query/{itemId}",method=RequestMethod.GET)
	@ResponseBody
	public E3Result getTbItemParameItem(@PathVariable Long itemId) {
		E3Result e3Result = itemParameItemService.getTbItemParameItem(itemId);
		return e3Result;
	}
	@RequestMapping(value="/rest/item/delete",method=RequestMethod.POST)
	@ResponseBody
	public E3Result deleteItems(Long[] ids) {
		itemService.deleteItems(ids);
		/*TbItem item = new TbItem();
		item.setStatus((byte)3);
		itemService.updateItems(ids, item);*/
		return E3Result.ok();
	}
	@RequestMapping(value="/rest/item/update",method=RequestMethod.POST)
	@ResponseBody
	public E3Result updateItems(TbItem item) {
		Long[] ids = {item.getId()};
		itemService.updateItems(ids, item);
		return E3Result.ok();
	}
	@RequestMapping(value="/rest/item/instock",method=RequestMethod.POST)
	@ResponseBody
	public E3Result instock(Long[] ids) {
		TbItem item = new TbItem();
		item.setStatus((byte)2);
		itemService.updateItems(ids, item);
		return E3Result.ok();
	}
	@RequestMapping(value="/rest/item/reshelf",method=RequestMethod.POST)
	@ResponseBody
	public E3Result reshelf(Long[] ids) {
		TbItem item = new TbItem();
		item.setStatus((byte)1);
		itemService.updateItems(ids, item);
		return E3Result.ok();
	}
}
