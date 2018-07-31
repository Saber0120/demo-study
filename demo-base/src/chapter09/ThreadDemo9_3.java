package chapter09;

/**
 * 通过Thread来实现售票
 * 发现并不好，无法达到共享资源的目的
 * Created by sheng on 2018/7/31.
 */
public class ThreadDemo9_3 {

    public static void main(String[] args) {
//        TestThread1 t = new TestThread1();
//        t.start();  //  这个线程正常执行
//        t.start();  //  java.lang.IllegalThreadStateException
//        t.start();
//        t.start();

        //  这样并不是多线程
        new TestThread1().start();
        new TestThread1().start();
        new TestThread1().start();
        new TestThread1().start();
    }
}

class TestThread1 extends Thread {

    private int ticket = 20;

    @Override
    public void run() {
        while (true) {
            if(ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "出售票" + ticket--);
            }
        }
    }
}