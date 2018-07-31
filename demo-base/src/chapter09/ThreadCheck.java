package chapter09;

/**
 * 检查线程的中断状态
 * Created by Administrator on 2018/7/31.
 */
public class ThreadCheck {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("A:thread is interrupted : " + thread.isInterrupted());
        thread.interrupt();
        System.out.println("B:thread is interrupted : " + thread.isInterrupted());
        System.out.println("C:thread is interrupted : " + thread.isInterrupted());
        try {
            //  已经被中断的线程调用sleep()，会抛出异常
            Thread.sleep(2000);
            System.out.println("线程未被中断！");
        } catch (InterruptedException e) {
//            e.printStackTrace();
            System.out.println("线程被中断！");
        }
        //  由于sleep()抛出异常，清空线程的中断标识
        System.out.println("D:thread is interrupted : " + thread.isInterrupted());
        try {
            Thread.sleep(2000);
            System.out.println("线程未被中断！");
        } catch (InterruptedException e) {
//            e.printStackTrace();
            System.out.println("线程被中断！");
        }
    }
}
