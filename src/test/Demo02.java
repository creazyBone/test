package test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class Demo02 {

	public String name;

	public static void main(String[] args) {
		/*
		 * Demo02 d1 = new Demo02(); d1.name = "Tom"; Demo02 d2 = new Demo02(); d2.name
		 * = "Jack";
		 * 
		 * Demo02 d = d1; d1 = d2; System.out.println(d.name);
		 * System.out.println(d1.name);
		 */

	//	MyThread thread = new MyThread();
	//	thread.start();
	//	thread.interrupt();
	//	System.out.println("��һ�ε���thread.isInterrupted()��" + thread.isInterrupted());
	//	System.out.println("�ڶ��ε���thread.isInterrupted()��" + thread.isInterrupted());
	//	System.out.println("thread�Ƿ��" + thread.isAlive());
		LockSupport.park();
		Thread.currentThread().interrupt();
		System.out.println("��һ�ε���thread.interrupted()��"+Thread.interrupted());
		System.out.println("�ڶ��ε���thread.interrupted()��"+Thread.interrupted());
	
	
	}

}

class MyThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("i=" + (i + 1));
		}
	}

}
