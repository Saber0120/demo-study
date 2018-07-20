package chapter03;

/**
 * 以下程序说明了局部变量的使用方法
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_34 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            sum = sum + i;  //  i是局部变量
            System.out.println("sum = " + sum + ", i = " + i);
        }
    }
}
