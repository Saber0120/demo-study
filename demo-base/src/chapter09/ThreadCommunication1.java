package chapter09;

/**
 * 线程间通信1
 * 线程Producer负责生产用户，绑定姓名和性别，线程Consumer负责消费用户
 * 问题：会出现"张三---女"，"李四---男"的情况
 * 原因：Producer在设置姓名和性别的时候，可能会出现在设置姓名后、设置性别前发生CPU的切换，此时Consumer消费到的用户是错误的
 * Created by sheng on 2018/8/1.
 */
public class ThreadCommunication1 {

    public static void main(String[] args) {
        Person p = new Person();
        new Thread(new Producer(p)).start();
        new Thread(new Consumer(p)).start();
    }
}

class Producer implements Runnable {

    private Person p;

    public Producer(Person p) {
        this.p = p;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (i % 2 == 0) {
                p.name = "李四";
                p.sex = "女";
            } else {
                p.name = "张三";
                p.sex = "男";
            }
            i++;
        }
    }
}

class Consumer implements Runnable {

    private Person p;

    public Consumer(Person p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(p.name + "---" + p.sex);
        }
    }
}

class Person {

    String name = "张三";

    String sex = "男";
}