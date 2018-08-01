package chapter09;

/**
 * 通过实现接口来实现售票
 * 可以达到资源共享的目的
 * Created by sheng on 2018/7/31.
 */
public class ThreadDemo9_4 {

    public static void main(String[] args) {
        TestThread3 t = new TestThread3();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}

class TestThread3 implements Runnable {

    private int ticket = 4;

    @Override
    public void run() {
        while (ticket > 0) {
            try {
                //  加上这段，就可以看出这段代码是线程不安全的，可能出现ticket为负数的情况
                //  当ticket等于1时，当线程1刚执行完ticket>0时，
                //  CPU切换到线程2，此时ticket>0，当线程2执行完毕后，ticket等于0，
                //  此时CPU切换回线程1，不会再判断ticket>0，所以线程1执行完后，ticket=-1
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "出售票" + ticket--);
        }
    }
}