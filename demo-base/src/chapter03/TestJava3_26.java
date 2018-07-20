package chapter03;

/**
 * 以下程序说明了多分支条件语句 if..else if ...else 的使用
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_26 {

    public static void main(String[] args) {
        int x = 1;
        if (x == 1) {
            System.out.println("x == 1");
        } else if (x == 2) {
            System.out.println("x == 2");
        } else if (x == 3) {
            System.out.println("x == 3");
        } else {
            System.out.println("x > 3");
        }
    }
}
