package cn.e3mall.service.impl.test;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PublishManagerService {
	@Test
	public void publishService() throws IOException {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		System.out.println("manager-service服务已启动。。。");
		System.in.read();
		System.out.println("服务已结束。。。");
		
	}
}
