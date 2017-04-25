package ch8.beannameautoproxy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyFactoryMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ch8beannameautoproxy.xml");
		UserService us = context.getBean("userServiceImpl", UserService.class);
		us.updateUser();
	}

}
