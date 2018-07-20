package chapter03;

/**
 * 下面的程序说明了 if 语句的操作，只有当条件满足时才会被执行
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_23 {

    public static void main(String[] args) {
        int a = 6;
        int b = 5;
        System.out.println("a = " + a + ", b = " + b);
        if (a > b)
            System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
    }
}
