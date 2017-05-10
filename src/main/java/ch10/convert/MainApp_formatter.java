package ch10.convert;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp_formatter {

	public static void main(String[] args) {
		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ch10Beans_formatter.xml");
		Team obj = (Team) context.getBean("t");
		System.out.println(obj.getNames());
		System.out.println(obj.getMemberCount());
		System.out.println(obj.getCreateDate());

	}

}
