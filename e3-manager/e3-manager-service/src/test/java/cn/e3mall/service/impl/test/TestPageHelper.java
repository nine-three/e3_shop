package cn.e3mall.service.impl.test;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;

/**
 * 
 * @Description 测试pagehelper插件
 * @author 席春光
 * @date 2018年3月6日
 *
 */
public class TestPageHelper {
	@Test
	public void test1() {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//获得Mapper的代理对象
		TbItemMapper itemMapper = context.getBean(TbItemMapper.class);
		//设置分页信息
		PageHelper.startPage(1, 30);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		System.out.println(pageInfo.getPageNum());
		System.out.println(pageInfo.getPageSize());
		
	}
}
