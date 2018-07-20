package chapter03;

/**
 * 在 JAVA 中用%进行取模操作
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_16 {

    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println(a + " % " + b + " = " + (a % b));
        System.out.println(b + " % " + a + " = " + (b % a));
    }
}
