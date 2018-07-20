package chapter03;

/**
 * 整数值如果超出了自己所可以表示范围的最大值，会出现溢出
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_4 {

    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;  //  获取int最大值
        System.out.println("x = " + x); //  x = 2147483647
        System.out.println("x+1 = " + (x + 1)); //  x+1 = -2147483648
        System.out.println("x+2 = " + (x + 2)); //  x+2 = -2147483647
        // 这个情形会出现一个循环，若是想避免这种情况的发生，在程序中就必须加上数值范围的检查功能，或者使用较大的表示范围的数据类型，如长整型。
    }
}
