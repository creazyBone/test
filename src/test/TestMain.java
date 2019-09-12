package test;

import java.util.concurrent.TimeUnit;

public class TestMain {
 //   public static volatile boolean flag = true;
    public static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                	try {
						TimeUnit.SECONDS.sleep(1);
						System.out.println("...");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                System.out.println(Thread.currentThread().getName() + "�߳�ֹͣ����ѭ������");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = false;
                System.out.println(Thread.currentThread().getName() + "�޸� flag Ϊ" + flag);
            }
        }).start();

      //  Thread.sleep(Integer.MAX_VALUE);
    }
}