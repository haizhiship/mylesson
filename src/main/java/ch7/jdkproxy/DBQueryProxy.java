package ch7.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*InvocationHandler ��̬����JDK�ṩ�Ľӿ�
 *target Ҫ����Ķ���
 * 
 */
public class DBQueryProxy implements InvocationHandler {

	Object target;// ��ʵ����

	public Object bind(Object target) {
		this.target = target;// ������ʵ����
		// ȡ�ô������
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	/*
	 * invoke Object invoke(Object proxy, Method method, Object[] args)
	 *
	 */
	// ҵ���߼��������invoke���� �߼��ж���ʵ����invoke�Ƿ����
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("query ID:" + arg2[0]);
		Object result = arg1.invoke(target, arg2);// ������ʵ����ķ�������DBQuery����ķ���
		return result;
	}

}
