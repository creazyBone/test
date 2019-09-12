package test;

/**
 * ThreadLocal 以及不同线程调用同一对象同一方法阻塞问题的实验
 * @author Administrator
 *
 */
public class Test {
	
	public ThreadLocal<String> tl = new ThreadLocal<>();
	
	public String str;
	
	public void aaa(int k) {
		if(k == 1) {
			System.out.println("method-"+ k +" start...");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(tl.get());
			System.out.println("str:"+str);
			System.out.println("method-"+ k +" finish!");
		}else if(k == 2) {
			System.out.println("method-"+ k +" start...");
			System.out.println(tl.get());
			System.out.println("str:"+str);
			System.out.println("method-"+ k +" finish!");
		}
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				test.tl.set("aaa");
				test.str = "hello";
				test.aaa(1);
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.tl.set("bbb");
				System.out.println("已经设置了str:"+test.str);
				test.str = "world";
				test.aaa(2);
			}
			
		});
		
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}

}
