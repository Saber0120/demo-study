package chapter09;

/**
 * 线程间通信3
 * 解决问题：出现了生产者生产多个用户，消费者才去消费的情况，应该是生产一个就消费一个
 * 解决方法：在用户类中添加一个标记，用来标记当前用户是刚被生产还是已经被消费，如果是刚被生产则通知消费者去消费，反之同理。
 * 说明：
 * 1、wait():在同步方法中使用，使当前线程进入休眠状态，并放弃当前锁，直到其他线程进入相同监视器，并调用notify()为止。
 * 2、notify():唤醒使用相同监视器中第一个调用了wait()的线程。
 * 3、notifyAll():唤醒所有使用相同监视器并调用了wait()的线程。
 * Created by sheng on 3018/8/1.
 */
public class ThreadCommunication3 {

    public static void main(String[] args) {
        Person3 p = new Person3();
        new Thread(new Producer3(p)).start();
        new Thread(new Consumer3(p)).start();
    }
}

class Producer3 implements Runnable {

    private Person3 p;

    public Producer3(Person3 p) {
        this.p = p;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (i % 2 == 0) {
                p.set("李四", "女");
            } else {
                p.set("张三", "男");
            }
            i++;
        }
    }
}

class Consumer3 implements Runnable {

    private Person3 p;

    public Consumer3(Person3 p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.get();
        }
    }
}

class Person3 {

    private String name = "张三";

    private String sex = "男";

    public boolean flag = true;

    public synchronized void set(String name, String sex) {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.sex = sex;
        flag = true;
        notify();
    }

    public synchronized void get() {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "---" + this.sex);
        flag = false;
        notify();
    }
}