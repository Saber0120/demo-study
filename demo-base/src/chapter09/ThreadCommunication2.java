package chapter09;

/**
 * 线程间通信2
 * 解决问题：出现"张三---女"，"李四---男"的情况
 * 解决方法：给用户类添加同步的set方法来设置姓名和性别
 * 新问题：出现了生产者生产多个用户，消费者才去消费的情况，应该是生产一个就消费一个
 * Created by sheng on 2018/8/1.
 */
public class ThreadCommunication2 {

    public static void main(String[] args) {
        Person2 p = new Person2();
        new Thread(new Producer2(p)).start();
        new Thread(new Consumer2(p)).start();
    }
}

class Producer2 implements Runnable {

    private Person2 p;

    public Producer2(Person2 p) {
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

class Consumer2 implements Runnable {

    private Person2 p;

    public Consumer2(Person2 p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.get();
        }
    }
}

class Person2 {

    private String name = "张三";

    private String sex = "男";

    public synchronized void set(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public synchronized void get() {
        System.out.println(this.name + "---" + this.sex);
    }
}