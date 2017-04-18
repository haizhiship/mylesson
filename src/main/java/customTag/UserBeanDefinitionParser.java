package customTag;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.context.support.SimpleThreadScope;
import org.w3c.dom.Element;

public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser{
	
	protected Class getBeanClass(Element element){
		
		return CustomScopeConfigurer.class;
		
	}
	
	protected void doParse(Element element, BeanDefinitionBuilder bean){
		Map<String, Object> scopes = new HashMap();
		if(!scopes.containsKey("thread")){
			SimpleThreadScope simpleThreadScope = new SimpleThreadScope();
			scopes.put("thread", simpleThreadScope);
			bean.addPropertyValue("scopes", scopes);
		}
	}

}
