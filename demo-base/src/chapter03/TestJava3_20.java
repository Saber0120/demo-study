package chapter03;

/**
 * 下面是关于简洁写法的一段程序
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_20 {

    public static void main(String[] args) {
        int a = 5;
        int b = 8;
        System.out.println("改变之前：a = " + a + ", b = " + b);
        a += b;
        System.out.println("改变之后：a = " + a + ", b = " + b);
    }
}
