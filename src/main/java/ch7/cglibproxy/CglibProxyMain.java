package ch7.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;

import ch7.aop.DBQueryInterceptor;

public class CglibProxyMain {

	public static void main(String[] args) {
		DBQuery query = createProxy(new DBQuery());
		System.out.println(query.request("1"));

	}

	/*
	 * enchancer ��ǿ���������ɴ���
	 *  setCallback����������ࡣ
	 *  create����һ���µ����ͣ������ɵ���������ʵ��������
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
