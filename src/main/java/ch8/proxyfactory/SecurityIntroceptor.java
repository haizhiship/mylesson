package ch8.proxyfactory;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SecurityIntroceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("=====ִ�а�ȫУ��======");
		return invocation.proceed();
	}

}
