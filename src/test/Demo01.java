package test;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Demo01 {
	
	
	public int a = 1;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		Demo01 d = new Demo01();
		ArrayList<FutureTask> taskList = new ArrayList<>();
		for(int k=1;k<=2;k++) {
			final int p = k;
			Callable<Integer> call = new Callable<Integer>() {
				
				@Override
				public Integer call() throws Exception {
					System.out.println("processing_"+ p +"...");
					for(int i=1;i<=5;i++) {
						d.a ++;
						TimeUnit.SECONDS.sleep(1);
					}
					System.out.println("process_"+ p +" done!");
					return d.a;
				}
				
			};
			FutureTask<Integer> task = new FutureTask<>(call);
			taskList.add(task);
			pool.submit(task);
			
		}
		
		System.out.println("do something in main thread...");
		
		TimeUnit.SECONDS.sleep(10);
		
		System.out.println("main thread finished.");
		
		for(FutureTask<Integer> f : taskList) {
			System.out.println(f.get());
		}
		System.out.println("finally a is:" + d.a);
		pool.shutdown();
	}
		
}
