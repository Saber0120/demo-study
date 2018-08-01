package chapter09;

/**
 * 死锁
 * Created by sheng on 2018/8/1.
 */
public class DeadLockDemo implements Runnable {

    public DeadLockDemo() {
        new Thread(this).start();
        b.funB(a);
        System.out.println(Thread.currentThread().getName() + "执行完毕");
    }

    private A a = new A();
    private B b = new B();

    @Override
    public void run() {
        a.funA(b);
        System.out.println(Thread.currentThread().getName() + "执行完毕");
    }

    public static void main(String[] args) {
        DeadLockDemo t = new DeadLockDemo();
    }
}

class A {

    synchronized void funA(B b) {
        System.out.println("进入A.funA");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("调用B.last");
        b.last();
    }

    synchronized void last() {
        System.out.println("进入A.last");
    }
}

class B {

    synchronized void funB(A a) {
        System.out.println("进入B.funB");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("调用A.last");
        a.last();
    }

    synchronized void last() {
        System.out.println("进入B.last");
    }
}