package ch7.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class DBQueryInterceptor implements MethodInterceptor {
	Object target;

	public DBQueryInterceptor(Object target) {
		this.target = target;
	}

	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("query ID:" + arg2[0]);
		Object result = arg3.invoke(target, arg2);
		return result;
	}

}
