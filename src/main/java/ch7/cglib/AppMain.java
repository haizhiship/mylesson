package ch7.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;

public class AppMain {

	public static void main(String[] args) {
		AppMain appMain = new AppMain();
		Task proxyTarget = (Task) appMain.createProxy(Task.class);
		String res = proxyTarget.execute();
		proxyTarget.endTask();

	}

	/*
	 * cglib使用多个切入点
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T createProxy(Class obj) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(obj);
		enhancer.setCallbacks(new Callback[] { new TaskInterceptor(), new TaskInterceptor2() });
		enhancer.setCallbackFilter(new CallbackFilter() {
			public int accept(Method method) {
				if (method.getName().equals("execute")) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		return (T) enhancer.create();
	}

}
