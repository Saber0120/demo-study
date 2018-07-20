package chapter03;

/**
 * 下面这段程序说明了除法运算符的使用方法
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_15 {

    public static void main(String[] args) {
        int a = 13;
        int b = 4;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a/b = " + (a / b));
        System.out.println("a/b = " + (float) a / b);   //  强制类型转换
    }
}
