package chapter03;

/**
 * 下面这段程序调用了表 3-2 中的方法，可以得到数据类型的最大值和最小值
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_3 {

    public static void main(String[] args) {
        long long_max = Long.MAX_VALUE;
        int int_max = Integer.MAX_VALUE;
        short short_max = Short.MAX_VALUE;
        byte byte_max = Byte.MAX_VALUE;

        System.out.println("long_max = " + long_max);
        System.out.println("int_max = " + int_max);
        System.out.println("short_max = " + short_max);
        System.out.println("byte_max = " + byte_max);
        System.out.println();

        long long_min = Long.MIN_VALUE;
        int int_min = Integer.MIN_VALUE;
        short short_min = Short.MIN_VALUE;
        byte byte_min = Byte.MIN_VALUE;

        System.out.println("long_min = " + long_min);
        System.out.println("int_min = " + int_min);
        System.out.println("short_min = " + short_min);
        System.out.println("byte_min = " + byte_min);
    }
}
