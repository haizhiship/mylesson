package ch8.beannameautoproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("securityIntroceptor")
public class SecurityIntroceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("=====ִ�а�ȫУ��======");
		return invocation.proceed();
	}

}
