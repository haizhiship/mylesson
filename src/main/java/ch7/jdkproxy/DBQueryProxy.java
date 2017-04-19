package ch7.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*InvocationHandler 动态代理JDK提供的接口
 *target 要代理的对象
 * 
 */
public class DBQueryProxy implements InvocationHandler {

	Object target;// 真实主题

	public Object bind(Object target) {
		this.target = target;// 保存真实主题
		// 取得代理对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	/*
	 * invoke Object invoke(Object proxy, Method method, Object[] args)
	 *
	 */
	// 业务逻辑代码放在invoke里面 逻辑判断真实主题invoke是否调用
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("query ID:" + arg2[0]);
		Object result = arg1.invoke(target, arg2);// 调用真实主题的方法，即DBQuery本身的方法
		return result;
	}

}
