package ch7.postprocessorandregualer;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ch7Regular.xml");
		RegularClass1 re1 = (RegularClass1) context.getBean("RegularClass1");
		RegularClass2 re2 = (RegularClass2) context.getBean("RegularClass2");

		re1.matchFunction();
		re1.noMatchFunction();

		re2.matchFunction();
		re2.noMatchFunction();
	}
}
