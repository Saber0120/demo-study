package chapter03;

/**
 * 以下程序说明了 for 循环的使用方法
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_30 {

    public static void main(String[] args) {
        int i, sum = 0;
        for (i = 1; i <= 10; i++) {
            sum += i;
        }

        System.out.println("1 + 2 + 3 + ... + 10 = " + sum);
    }
}
