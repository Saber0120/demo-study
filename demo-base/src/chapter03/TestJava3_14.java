package chapter03;

/**
 * 下面这段程序说明了一元运算符的使用
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_14 {

    public static void main(String[] args) {
        byte a = Byte.MAX_VALUE;
        boolean b = false;

        System.out.println("a = " + a + ", ~a = " + ~a);    //  a = 127, ~a = -128
        System.out.println("b = " + b + ", !b = " + !b);
        //  ~:取补码
    }
}
