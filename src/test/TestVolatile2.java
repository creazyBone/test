package test;

public class TestVolatile2 extends Thread{
	
	 private static volatile boolean flag = false;

	    public void run() {
	        while (!flag) {
	        //	int a;
	        //	System.out.println("running...");
	        };
	    }

	    public static void main(String[] args) throws Exception {
	        new TestVolatile2().start();
	        Thread.sleep(2000);
	        flag = true;
	    }
}
