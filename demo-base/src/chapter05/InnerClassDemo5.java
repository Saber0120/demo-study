package chapter05;

/**
 * 在方法中定义的内部类只能访问方法中的 final 类型的局部变量，因为用 final 定义的局部变量相当于是一个常量，它的生命周期超出方法运行的生命周期。
 * 注：jdk8中已经可以访问非final定义的变量了
 * Created by sheng on 2018/7/25.
 */
public class InnerClassDemo5 {

    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        outer2.inst(55);
    }
}

class Outer2 {

    int score = 95;

    void inst(final int s) {
        int temp = 20;  //  jdk8之前的版本，这里得声明为final
        class Inner {
            void display() {
                System.out.println("score + s + temp : " + (score + s + temp));
            }
        }
        Inner inner = new Inner();
        inner.display();
    }
}