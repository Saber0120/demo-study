package chapter09;

/**
 * 线程的生命周期
 * 1、控制生命周期的方法：suspend、resume、stop。（都不推荐使用）
 * a）前两个可能会造成死锁，并且它允许一个线程通过代码直接控制另一个线程
 * b）最后一个虽然不会死锁，但如果在操作共享数据时调用，造成数据不完整的错误
 *
 * 解决方法：
 * 设计一个标记变量，通过改变标记变量的值，来控制线程的生命周期
 * Created by sheng on 2018/8/1.
 */
public class ThreadLife {

    public static void main(String[] args) {
        TestThread7 t = new TestThread7();
        new Thread(t).start();
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                t.flag = false;
            }
            System.out.println(Thread.currentThread().getName() + "---正在运行");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TestThread7 implements Runnable {

    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "---正在运行");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}