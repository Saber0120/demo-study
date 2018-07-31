package chapter09;

/**
 * 线程的强制运行
 * Created by Administrator on 2018/7/31.
 */
public class ThreadJoin {

    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        Thread th = new Thread(t);
        th.start();

        for (int i = 0; i < 10;) {
            if (i == 5) {
                try {
                    //  调用join()后，发现之后th线程还在运行，即调用join()后将强制某个线程进行，
                    th.join();
                    //  方法里的数字表示两个线程合并n毫秒后，又将分开，回到合并前的状态。
//                    th.join(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " is running---" + i++);
        }
    }
}

class ThreadTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10;) {
            System.out.println(Thread.currentThread().getName() + " is running--->" + i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}