package chapter09;

/**
 * 线程的中断
 * Created by Administrator on 2018/7/31.
 */
public class SleepInterrupt implements Runnable {

    public static void main(String[] args) {
        SleepInterrupt s = new SleepInterrupt();
        Thread thread = new Thread(s);
        thread.start();

        try {
            //  让thread线程运行一会
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("在main()中，中断其他线程");
        thread.interrupt(); //  在main线程中，调用其它线程的interrupt()，使其它线程中断，可调用isInterrupted()来查看线程状态
        System.out.println("在main()中，退出");
    }

    @Override
    public void run() {
        try {
            System.out.println("在run()中，让这个线程休眠20秒");
            Thread.sleep(20000);
            System.out.println("在run()中，继续进行");
        } catch (InterruptedException e) {
//            e.printStackTrace();
            System.out.println("在run()中，线程中断");
            return;
        }
        System.out.println("在run()中，休眠结束后继续进行");

    }
}
