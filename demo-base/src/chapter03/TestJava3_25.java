package chapter03;

/**
 * 以下程序说明了条件运算符的使用方法
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_25 {

    public static void main(String[] args) {
        int a = 5, b = 13, max;

        max = a > b ? a : b;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("最大的数是 " + max);
    }
}
