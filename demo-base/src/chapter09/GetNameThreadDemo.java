package chapter09;

/**
 * 取得线程的名称
 * 程序启动时，会默认启动两个线程，一个是main()线程，另一个时GC线程
 * Created by Administrator on 2018/7/31.
 */
public class GetNameThreadDemo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            printMsg();
        }
    }

    private void printMsg() {
        //  获得运行此代码的线程的引用
        Thread t = Thread.currentThread();
        String name = t.getName();
        System.out.println(name);
    }

    public static void main(String[] args) {
        GetNameThreadDemo g = new GetNameThreadDemo();
        g.start();

        for (int i = 0; i < 10; i++) {
            g.printMsg();   //  这里或得到的线程引用是main线程
        }
    }
}

