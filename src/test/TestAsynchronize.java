package test;

import java.util.concurrent.CountDownLatch;

public class TestAsynchronize {

	public int a = 10;
	
	
	
	public static void main(String[] args) throws InterruptedException {
		TestAsynchronize tas = new TestAsynchronize();
	//	CountDownLatch count = new CountDownLatch(1);
		System.out.println(tas.a);
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tas.a++;
		//		count.countDown();
			}
		}).start();
		
	//	count.await();
	
		System.out.println("main-thread is over with a:"+ tas.a + "!");
		
		
	}
}
