package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Demo {

	public static void main(String[] args) {
		
		Callable<Integer> task = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				System.out.println("���̼߳��㿪ʼ...");
				TimeUnit.SECONDS.sleep(5);
				System.out.println("���̼߳������...");
				return 100;
			}
			
		};
		
		/*��ʽһ��Thread
		FutureTask<Integer> future = new FutureTask<Integer>(task);
		Thread t = new Thread(future);
		t.start();
		System.out.println("���̼߳���ִ��...");
		try {
			Integer result = future.get();
			System.out.println("��������" + result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		/*��ʽ����ExecutorService + Future
		ExecutorService pool = Executors.newFixedThreadPool(1);
		Future<Integer> future = pool.submit(task);
		System.out.println("���̼߳���ִ��...");
		pool.shutdown();
		Integer result;
		try {
			result = future.get();
			System.out.println("��������" + result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*��ʽ����ExecutorService + FutureTask*/
		ExecutorService pool = Executors.newCachedThreadPool();
		FutureTask<Integer> ft = new FutureTask<Integer>(task);
		pool.submit(ft);
	//	Future future = pool.submit(ft);
		System.out.println("���̼߳���ִ��...");
		pool.shutdown();
		Integer result;
	//	Integer result2;
		try {
			result = ft.get();
		//	result2 =(Integer)future.get();
			System.out.println("��������" + result);
		//	System.out.println("������2��" + result2);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
