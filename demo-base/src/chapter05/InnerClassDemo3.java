package chapter05;

/**
 * 在类外部引用内部类
 * Created by sheng on 2018/7/23.
 */
public class InnerClassDemo3 {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.display();
    }
}

class Outer {

    int score = 95;

    void inst() {
        Inner inner = new Inner();
        inner.display();
    }

    class Inner {

        void display() {
            System.out.println("score: " + score);
        }
    }
}
