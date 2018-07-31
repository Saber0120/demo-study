package chapter09;

/**
 * 线程是否已经启动而且仍然在启动
 * Created by Administrator on 2018/7/31.
 */
public class StartThreadDemo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            printMsg();
        }
    }

    private void printMsg() {
        Thread t = Thread.currentThread();
        String name = t.getName();
        System.out.println("name = " + name);
    }

    public static void main(String[] args) {
        StartThreadDemo s = new StartThreadDemo();
        System.out.println("start()之前，线程状态：" + s.isAlive());
        s.start();
        System.out.println("start()之后，线程状态：" + s.isAlive());
        for (int i = 0; i < 10; i++) {
            s.printMsg();
        }
        System.out.println("main线程后，线程状态：" + s.isAlive());  //  这里结果的true和false均有可能
    }
}
