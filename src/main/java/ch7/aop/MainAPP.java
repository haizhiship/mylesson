package ch7.aop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAPP {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ch7Aop.xml");
		DBQuery obj = context.getBean(DBQuery.class);
		String re = obj.request("aaa");
		System.out.println(re);
	}

}
