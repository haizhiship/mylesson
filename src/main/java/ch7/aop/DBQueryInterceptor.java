package ch7.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/*
 * JDK本身的动态代理必须实现接口，局限性
 * JDK中的动态代理是通过反射类Proxy以及InvocationHandler回调接口实现的，
 * 但是，JDK中所要进行动态代理的类必须要实现一个接口，也就是说只能对该类所实现接口中定义的方法进行代理，
 * 这在实际编程中具有一定的局限性，而且使用反射的效率也并不是很高。
 * 使用CGLib实现动态代理，完全不受代理类必须实现接口的限制，
 * 而且CGLib底层采用ASM字节码生成框架，使用字节码技术生成代理类，
 * 比使用Java反射效率要高。
 * 通过MethodInterceptor实现
 */
public class DBQueryInterceptor implements MethodInterceptor {
	Object target;

	public DBQueryInterceptor(Object target) {
		this.target = target;
	}
	/*arg0代理后的对象
	 *arg1被调用的方法 
	 *arg2方法的参数
	 *arg3没有别切入的方法，避免死循环和递归调用
	 */
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("query ID:" + arg2[0]);
		Object result = arg3.invoke(target, arg2);
		return result;
	}

}
