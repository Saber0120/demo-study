package chapter03;

/**
 * 以下程序说明了 while 循环的使用方法
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_28 {

    public static void main(String[] args) {
        int i = 1, sum = 0;

        while (i <= 10) {
            sum += i;
            i++;
        }

        System.out.println("1 + 2 + 3 + ... + 10 = " + sum);
    }
}
