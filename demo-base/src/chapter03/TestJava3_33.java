package chapter03;

/**
 * 下面的程序是介绍 continue 的使用方法
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_33 {

    public static void main(String[] args) {
        int i;
        for (i = 1; i < 10; i++) {
            if (i % 3 == 0)
                continue;
            System.out.println("i = " + i);
        }
        System.out.println("循环中断，i = " + i);
    }
}
