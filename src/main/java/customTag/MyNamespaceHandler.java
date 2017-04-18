package customTag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyNamespaceHandler extends NamespaceHandlerSupport{

	public void init() {
		// TODO Auto-generated method stub
		registerBeanDefinitionParser("thread",new UserBeanDefinitionParser());
		
	}

}
