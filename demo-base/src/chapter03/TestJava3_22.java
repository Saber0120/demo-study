package chapter03;

/**
 * 表达式类型转换：
 * 1、 占用字节较少的类型转换成占用字节较多的类型。
 * 2、 字符类型会转换成 int 类型。
 * 3、 int 类型会转换成 float 类型。
 * 4、 表达式中若某个操作数的类型为 double，则另一个操作数字也会转换成 double类型。
 * 5、 布尔类型不能转换成其它类型。
 * <p>
 * 下面的程序说明了表达式类型的自动转换问题
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_22 {

    public static void main(String[] args) {
        char ch = 'a';
        short a = -2;
        int b = 3;
        float f = 5.3f;
        double d = 6.28;

        System.out.print("(ch / a) - (d / f) - (a + b) = ");
        System.out.println((ch / a) - (d / f) - (a + b));   //  是double类型
    }
}
