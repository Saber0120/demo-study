package chapter07;

/**
 * 抛出异常
 * Created by sheng on 2018/7/31.
 */
public class TestException7_4 {

    public static void main(String[] args) {
        int a = 4, b = 0;
        try {
            if (b == 0) {
                throw new ArithmeticException("一个算术异常");
            } else {
                System.out.println(a + " / " + b + " = " + (a / b));
            }
        } catch (ArithmeticException e) {
            System.out.println("异常为：" + e);
        }
    }
}
