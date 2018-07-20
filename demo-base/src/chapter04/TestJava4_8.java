package chapter04;

/**
 * 以下程序主要说明如何去声明并使用一个方法
 * Created by Administrator on 2018/7/20.
 */
public class TestJava4_8 {

    public static void main(String[] args) {
        star();
        System.out.println("I like Java!");
        star();
    }

    public static void star() {
        for (int i = 0; i < 19; i++)
            System.out.print("*");
        System.out.println();
    }
}
