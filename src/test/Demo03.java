package test;

import java.util.concurrent.TimeUnit;
/**
 * volatile test
 * @author Administrator
 *
 */
public class Demo03 {
	
	public volatile boolean flag = false;
	
	public static void main(String[] args) {
		
		Demo03 d = new Demo03();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for(int i=1;i<=10;i++) {
					System.out.println(i);
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+"�Ѿ�ִ����ϣ�");
				d.flag = true;
			}
		});
		
		Thread t2 = new Thread(()-> {
			while(!d.flag) {
				//����
			}
			System.out.println(Thread.currentThread().getName()+"��ʼִ�У�");
		});
		
		t1.start();
		t2.start();
	}

}
