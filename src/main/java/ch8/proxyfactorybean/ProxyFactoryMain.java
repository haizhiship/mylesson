package ch8.proxyfactorybean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyFactoryMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ch8proxyfactorybean.xml");
		UserService us = (UserService) context.getBean("userService");
		us.updateUser();
	}

}
