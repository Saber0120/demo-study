package chapter09;

/**
 * 线程的休眠
 * Created by Administrator on 2018/7/31.
 */
public class TwoThreadSleep extends Thread {

    @Override
    public void run() {
        loop();
    }

    private void loop() {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.println(name + " 进入loop方法");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("name = " + name);
        }
        System.out.println(name + " 离开loop方法");
    }

    public static void main(String[] args) {
        TwoThreadSleep thread = new TwoThreadSleep();
        thread.setName("my work thread");
        thread.start();

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.loop();
    }
}
