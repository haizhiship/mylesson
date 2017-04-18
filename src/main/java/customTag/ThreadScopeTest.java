package customTag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThreadScopeTest {
	
	public static void main(String[] args) throws InterruptedException { 
		final ApplicationContext appc = new ClassPathXmlApplicationContext("mybeans.xml");
		//�����߳�
		 new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				User user1 = (User) appc.getBean("testBean"); 
				System.out.println("�����߳�user1��hash=" + System.identityHashCode(user1));
			}  
		}).start();
	}

}
