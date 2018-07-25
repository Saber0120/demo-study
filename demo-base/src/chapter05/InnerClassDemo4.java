package chapter05;

/**
 * 在方法中定义内部类
 * Created by sheng on 2018/7/25.
 */
public class InnerClassDemo4 {

    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        outer1.inst();
    }
}

class Outer1 {

    int score = 95;

    void inst() {
        class Inner {
             void display() {
                 System.out.println("score: " + score);
             }
        }
        Inner inner = new Inner();
        inner.display();
    }
}
