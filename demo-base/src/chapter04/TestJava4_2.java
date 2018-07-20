package chapter04;

/**
 * 一维数组的赋值，这里采用静态方式赋值
 * Created by sheng on 2018/7/20.
 */
public class TestJava4_2 {

    public static void main(String[] args) {
        int i;
//        int[] a = new int[]{5, 6, 8};
        int[] a = new int[3];
        a[0] = 5;
        a[1] = 6;
        a[2] = 8;

        for (i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "] = " + a[i] + "\t");
        }
        System.out.println("\n数组长度是：" + a.length);
    }
}
