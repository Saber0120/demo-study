package chapter03;

/**
 * 下面的程序说明了简洁表达式的使用方法，但这种方式现在已不提倡使用了。
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_21 {

    public static void main(String[] args) {
        int a = 10;
        int b = 6;
        System.out.println("改变之前：a = " + a + ", b = " + b);
        a -= b++;
        System.out.println("改变之后：a = " + a + ", b = " + b);
    }
}
