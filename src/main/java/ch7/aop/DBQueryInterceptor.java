package ch7.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/*
 * JDK����Ķ�̬�������ʵ�ֽӿڣ�������
 * JDK�еĶ�̬������ͨ��������Proxy�Լ�InvocationHandler�ص��ӿ�ʵ�ֵģ�
 * ���ǣ�JDK����Ҫ���ж�̬����������Ҫʵ��һ���ӿڣ�Ҳ����˵ֻ�ܶԸ�����ʵ�ֽӿ��ж���ķ������д���
 * ����ʵ�ʱ���о���һ���ľ����ԣ�����ʹ�÷����Ч��Ҳ�����Ǻܸߡ�
 * ʹ��CGLibʵ�ֶ�̬������ȫ���ܴ��������ʵ�ֽӿڵ����ƣ�
 * ����CGLib�ײ����ASM�ֽ������ɿ�ܣ�ʹ���ֽ��뼼�����ɴ����࣬
 * ��ʹ��Java����Ч��Ҫ�ߡ�
 * ͨ��MethodInterceptorʵ��
 */
public class DBQueryInterceptor implements MethodInterceptor {
	Object target;

	public DBQueryInterceptor(Object target) {
		this.target = target;
	}
	/*arg0�����Ķ���
	 *arg1�����õķ��� 
	 *arg2�����Ĳ���
	 *arg3û�б�����ķ�����������ѭ���͵ݹ����
	 */
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("query ID:" + arg2[0]);
		Object result = arg3.invoke(target, arg2);
		return result;
	}

}
