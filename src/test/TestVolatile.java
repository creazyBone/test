package test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestVolatile {

	//private static volatile Integer t=0;
	
	private static AtomicInteger t= new AtomicInteger(0);
	
	private static Integer add(){
	//	return t++;
		return t.getAndAdd(1);
	}

	public static void test() {
		for (int i = 0; i < 20; i++) {
			Thread thread = new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					add();
				}
			});
			thread.start();
		}
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println(t);
	}

	public static void main(String[] args) {
		test();
	}

	/*
	 * public volatile int a = 0;
	 * 
	 * 
	 * public void add() { try { TimeUnit.MILLISECONDS.sleep(100); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } a++; //a++ <===>a=a+1 1)b=a+1 2)a=b
	 * System.out.println(a); }
	 * 
	 * public static void main(String[] args) { TestVolatile tv = new
	 * TestVolatile(); ExecutorService pool = Executors.newFixedThreadPool(20);
	 * for(int i = 1;i<=100;i++) { pool.submit(new Runnable() {
	 * 
	 * @Override public void run() { tv.add(); }
	 * 
	 * }); } pool.shutdown(); }
	 */
}
