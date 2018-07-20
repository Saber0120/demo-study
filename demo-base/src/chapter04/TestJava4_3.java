package chapter04;

/**
 * 这个程序主要是求得数组中的最大值和最小值
 * Created by sheng on 2018/7/20.
 */
public class TestJava4_3 {

    public static void main(String[] args) {
        int i, min, max;
        int[] a = new int[]{23, 87, 44, 55};
        min = max = a[0];
        System.out.print("数组的元素有：");
        for (i = 0; i < a.length; i++) {
            System.out.print(" " + a[i] + " ");
            if (a[i] < min)
                min = a[i];
            if (a[i] > max)
                max = a[i];
        }
        System.out.println("\n数组中最大值为：" + max);
        System.out.println("数组中最小值为：" + min);
    }
}
