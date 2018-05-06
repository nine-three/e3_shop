package cn.e3mall.controller;
/**
 * 
 * @Description 内容管理controller
 * @author 席春光
 * @date 2018年2月25日
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;
@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	
	@RequestMapping(value="/content/query/list",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult getContentList(int page,int rows,Long categoryId) {
		EasyUIDataGridResult dataGridResult = contentService.getContentList(page, rows, categoryId);
		return dataGridResult;
	}
	/**
	 * 添加内容
	 * @param parentID
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/content/save",method=RequestMethod.POST)
	@ResponseBody
	public E3Result createContent(TbContent content) {
		E3Result e3Result = contentService.addContent(content);
		return e3Result;
	}
	/**
	 * 更新内容
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/rest/content/edit",method=RequestMethod.POST)
	@ResponseBody
	public E3Result updateContent(Long id,TbContent content) {
		E3Result e3Result = contentService.updateContent(id, content);
		return e3Result;
	}
	/**
	 * 删除内容
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/content/delete",method=RequestMethod.POST)
	@ResponseBody
	public E3Result deleteContent(long[] ids) {
		E3Result e3Result = contentService.deleteContent(ids);
		return e3Result;
	}
}
