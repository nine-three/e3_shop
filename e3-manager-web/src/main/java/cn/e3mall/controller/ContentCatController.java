package cn.e3mall.controller;
/**
 * 
 * @Description 内容分类管理controller
 * @author 席春光
 * @date 2018年2月25日
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCategoryService;
import cn.e3mall.pojo.TbContentCategory;
@Controller
public class ContentCatController {
	
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	
	@RequestMapping(value="/content/category/list",method=RequestMethod.GET)
	@ResponseBody
	public List<EasyUITreeNode> getContentCatList(@RequestParam(name="id",defaultValue="0") Long parentID) {
		List<EasyUITreeNode> contentCatList = contentCategoryService.getContentCatList(parentID);
		return contentCatList;
	}
	/**
	 * 添加分类
	 * @param parentID
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/content/category/create",method=RequestMethod.POST)
	@ResponseBody
	public E3Result createContentCat(Long parentId,String name) {
		E3Result e3Result = contentCategoryService.addContentCategory(parentId, name);
		return e3Result;
	}
	/**
	 * 更新分类
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/content/category/update",method=RequestMethod.POST)
	@ResponseBody
	public E3Result updateContentCat(Long id,String name) {
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		E3Result e3Result = contentCategoryService.updateContentCat(id, contentCategory);
		return e3Result;
	}
	/**
	 * 删除分类
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/content/category/delete",method=RequestMethod.POST)
	@ResponseBody
	public E3Result deleteContentCat(Long id) {
		E3Result e3Result = contentCategoryService.deleteContentCat(id);
		return e3Result;
	}
}
