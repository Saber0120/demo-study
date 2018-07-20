package chapter04;

/**
 * 以下程序说明了方法的重载操作
 * Created by Administrator on 2018/7/20.
 */
public class TestJava4_11 {

    public static void main(String[] args) {
        int int_sum;
        double double_sum;
        int_sum = add(22, 13);
        System.out.println("add(22, 13) = " + int_sum);
        int_sum = add(22, 13, 35);
        System.out.println("add(22, 13, 35) = " + int_sum);
        double_sum = add(13.5, 22.3);
        System.out.println("add(13.5, 22.3) = " + double_sum);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static double add(double a, double b) {
        return a + b;
    }
}
