package chapter03;

/**
 * 以下程序说明了 do...while 循环的使用
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_29 {

    public static void main(String[] args) {
        int i = 1, sum = 0;
        do {
            sum += i;
            i++;
        } while (i <= 10);

        System.out.println("1 + 2 + 3 + ... + 10 = " + sum);
    }
}
