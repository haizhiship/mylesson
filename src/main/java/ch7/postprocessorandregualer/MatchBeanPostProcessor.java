package ch7.postprocessorandregualer;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

public class MatchBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub

		Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
		for (Method method : methods) {
			if (matchRegular(method.getName())) { // 如果方法名称不含有“noMathc”
				System.out.println("Match function has invoke!" + beanName + ":" + method.getName());
				ReflectionUtils.invokeMethod(method, bean);
			}

		}
		return bean;
	}

	// 返回方法名称是否有noMatch的结果
	public Boolean matchRegular(String methodName) {

		return methodName.matches(".*match.*");

	}

}
