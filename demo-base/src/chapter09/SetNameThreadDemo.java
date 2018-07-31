package chapter09;

/**
 * 设置线程的名称
 * Created by Administrator on 2018/7/31.
 */
public class SetNameThreadDemo extends Thread {

    public static void main(String[] args) {
        SetNameThreadDemo s = new SetNameThreadDemo();
        s.setName("SetNameThreadDemo"); //  设置线程名称
        s.start();

        for (int i = 0; i < 10; i++) {
            s.printMsg();
        }
    }

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
}

