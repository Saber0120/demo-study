package chapter09;

/**
 * 通过实现Runnable实现多线程
 * Created by sheng on 2018/7/31.
 */
public class ThreadDemo9_2 {

    public static void main(String[] args) {
        TestThread2 t = new TestThread2();
        new Thread(t).start();

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

class TestThread2 implements Runnable {

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