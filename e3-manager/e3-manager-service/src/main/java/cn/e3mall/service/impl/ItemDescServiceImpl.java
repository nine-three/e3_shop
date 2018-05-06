package cn.e3mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.service.ItemDescService;
/**
 * 
 * @Description 商品描述类
 * @author 席春光
 * @date 2018年2月25日
 *
 */
@Service
public class ItemDescServiceImpl implements ItemDescService {
	
	@Autowired
	private TbItemDescMapper itemDescMapper;

	@Override
	public E3Result getTbItemDescById(Long itemId) {
		TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
		return E3Result.ok(itemDesc);
	}
}
