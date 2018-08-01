package chapter09;

/**
 * 同步代码块
 * 将具有原子性的代码放入synchronized块内，同一时刻只有一个线程可以进入
 * Created by sheng on 2018/8/1.
 */
public class TestSynchronized1 {

    public static void main(String[] args) {
        TestThread5 t = new TestThread5();
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

class TestThread5 implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        synchronized (this) {
            while (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "出售票" + ticket--);
            }
        }
    }
}