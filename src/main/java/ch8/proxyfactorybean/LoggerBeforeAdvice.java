package ch8.proxyfactorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("loggerBeforeAdvice")
public class LoggerBeforeAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("=====���������־======");
		return invocation.proceed();
	}

}
