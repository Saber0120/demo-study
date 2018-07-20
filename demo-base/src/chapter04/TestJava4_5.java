package chapter04;

import java.util.Arrays;

/**
 * 以下程序是数组的排序操作，在这里使用了 sort 方法对数组进行排序
 * Created by sheng on 2018/7/20.
 */
public class TestJava4_5 {

    public static void main(String[] args) {
        int[] a = {4, 32, 45, 32, 65, 32, 2, 77};

        System.out.print("排序前，数组a的元素有：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i] + " ");
        }
        System.out.println();

        Arrays.sort(a);

        System.out.print("排序后，数组a的元素有：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < a.length / 2; i++) {
//            int temp = a[i];
//            a[i] = a[a.length - 1 - i];
//            a[a.length - 1 - i] = temp;

            a[i] = a[i] + a[a.length - 1 - i];
            a[a.length - 1 - i] = a[i] - a[a.length - 1 - i];
            a[i] = a[i] - a[a.length - 1 - i];
        }

        System.out.print("倒序后，数组a的元素有：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i] + " ");
        }
        System.out.println();
    }
}
