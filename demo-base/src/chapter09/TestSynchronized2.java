package chapter09;

/**
 * 同步方法
 * 同一时间只允许有一个线程进入同步方法
 * Created by sheng on 2018/8/1.
 */
public class TestSynchronized2 {

    public static void main(String[] args) {
        TestThread6 t = new TestThread6();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class TestThread6 implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        while (ticket > 0) {
            sale();
        }
    }

    private synchronized void sale() {
        if (ticket > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "出售票" + ticket--);
        }
    }
}