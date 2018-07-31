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

    private int ticket = 20;

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "出售票" + ticket--);
        }
    }
}