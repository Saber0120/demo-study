package chapter03;

/**
 * 下面范例中说明了自动转换和强制转换这两种转换的使用方法
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_12 {

    public static void main(String[] args) {
        int a = 55;
        int b = 9;
        float g,h;

        System.out.println("a =" + a + ", b = " + b);
        g = a / b;  //  当两个整数相除时，小数点以后的数字会被截断，使得运算的结果保持为整数
        System.out.println("a/b = " + g);
        h = (float) a / b;  //  /在这里将数据类型进行强制类型转换
        System.out.println("a/b = " + h);
    }
}
