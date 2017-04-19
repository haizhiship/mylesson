package ch7.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class TaskInterceptor2 implements MethodInterceptor {

	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(">>>MethodInterceptor2 start----");
		Object result = arg3.invokeSuper(arg0, arg2);
		System.out.println(">>>MethodInterceptor2 end----");
		return result;
	}

}
