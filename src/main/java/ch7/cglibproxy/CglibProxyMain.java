package ch7.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;

import ch7.aop.DBQueryInterceptor;

public class CglibProxyMain {

	public static void main(String[] args) {
		DBQuery query = createProxy(new DBQuery());
		System.out.println(query.request("1"));

	}

	/*
	 * enchancer 增强器用于生成代理。
	 *  setCallback具体切入的类。
	 *  create生成一个新的类型，新生成的类型生成实例做返回
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T createProxy(Object obj) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(obj.getClass());
		enhancer.setCallback(new DBQueryInterceptor(obj));
		return (T) enhancer.create();
	}
}
