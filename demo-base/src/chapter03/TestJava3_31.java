package chapter03;

/**
 * 以下程序说明了 for 循环的嵌套使用方法
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_31 {

    public static void main(String[] args) {
        int i, j;
        for (i = 1; i <= 9; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + (j * i) + "\t");
            }
            System.out.println();
        }
    }
}
