package chapter09;

/**
 * 后台线程与 setDaemon()方法
 * 只要有一个前台线程在运行，进程就不会结束，如果只有后台线程在运行，则进程就会结束
 * Created by Administrator on 2018/7/31.
 */
public class ThreadDaemon {

    public static void main(String[] args) {
        TestThread4 t = new TestThread4();
        Thread thread = new Thread(t);
        thread.setDaemon(true); //  设置成为后台运行
        thread.start();
    }
}

class TestThread4 implements Runnable {

    @Override
    public void run() {
        //  虽然是死循环，但是由于是后台线程，所以程序停止了
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is running!");
        }
    }
}