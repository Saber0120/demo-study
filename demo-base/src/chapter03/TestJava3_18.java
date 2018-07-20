package chapter03;

/**
 * 下面这段程序说明了“++”的两种用法的使用
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_18 {

    public static void main(String[] args) {
        int a = 3;
        int b = 3;

        System.out.print("a = " + a);
        System.out.print(", a++ = " + a++);
        System.out.println(", a = " + a);

        System.out.print("b = " + b);
        System.out.print(", ++b = " + ++b);
        System.out.println(", b = " + b);
    }
}
