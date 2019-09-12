package test;
public class RunThread extends Thread {
    /** volatile */
    private volatile boolean isRunning = true;

    private void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void run() {
        System.out.println("���� run() ������...");
        while (isRunning == true) {
            // doSomething()
        }
        System.out.println("�߳̽�����...");
    }

    public static void main(String[] args) throws InterruptedException {
        RunThread myThread = new RunThread();
        myThread.start();
        Thread.sleep(3000);
        myThread.setRunning(false);
        System.out.println("isRunning ��ֵ�Ѿ�����Ϊ�� false");
        Thread.sleep(1000);
        System.out.println(myThread.isRunning);
    }
}