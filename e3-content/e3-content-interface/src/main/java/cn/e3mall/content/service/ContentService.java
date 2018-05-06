package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbContent;

public interface ContentService {
	EasyUIDataGridResult getContentList(int page, int rows,long categoryId);
	E3Result addContent(TbContent content);
	E3Result deleteContent(long[] ids);
	E3Result updateContent(long id,TbContent content);
	List<TbContent> getContentListByCid(long cid);
}
