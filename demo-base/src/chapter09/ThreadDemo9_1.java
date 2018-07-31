package chapter09;

/**
 * 继承Thread来实现多线程
 *
 * Created by sheng on 2018/7/31.
 */
public class ThreadDemo9_1 {

    public static void main(String[] args) {
        new TestThread().start();

        for (int i = 0; i < 10; i++) {
            System.out.println("MainThread is run...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TestThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("TestThread is run...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}