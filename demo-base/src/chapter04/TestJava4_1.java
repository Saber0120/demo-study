package chapter04;

/**
 * 下面这段程序说明了一维数组的使用方法
 * Created by sheng on 2018/7/20.
 */
public class TestJava4_1 {

    public static void main(String[] args) {
        int i;
        int[] a;    //  声明整型数组 a
        a = new int[3]; //  开辟了一块内存空间，12个byte
        for (i = 0; i < 3; i++) {
            System.out.print("a[" + i + "] = " + a[i] + "\t");
        }
        System.out.println("\n数组长度是：" + a.length);
    }
}
