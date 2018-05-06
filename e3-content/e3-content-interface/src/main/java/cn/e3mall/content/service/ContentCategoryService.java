package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbContentCategory;

public interface ContentCategoryService {
	List<EasyUITreeNode> getContentCatList(Long parentID);
	E3Result addContentCategory(long parentId, String name);
	E3Result deleteContentCat(long id);
	E3Result updateContentCat(long id,TbContentCategory contentCategory);
}
