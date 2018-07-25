package chapter05;

/**
 * 内部类
 * Created by sheng on 2018/7/23.
 */
public class InnerClassDemo {

    int score = 95;

    void inst() {
        Inner inner = new Inner();
        inner.display();
    }

    void print() {
        // System.out.println("name = " + name);   //  外部类无法访问内部类的属性
    }

    class Inner {

        String name = "张三";

        void display() {
            System.out.println("score = " + score); //  内部类可以直接调用外部类的属性
        }
    }

    static class StaticInner {
        void display() {
            // System.out.println("score = " + score); //  静态内部类不能访问外部类的非static属性
        }
    }

    public static void main(String[] args) {
        InnerClassDemo innerClassDemo = new InnerClassDemo();
        innerClassDemo.inst();
    }
}
