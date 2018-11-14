package com.structure.sort;

/**
 * 插入排序：将后面插入前面的序列中
 * Created by sheng on 2018/11/14.
 */
public class InsertSort {

    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int tmp = array[j];
            while (j > 0 && tmp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = tmp;
            System.out.print("第" + i + "轮排序后结果为：");
            display(array);
        }
        return array;
    }

    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {7,4,9,6,2,3,5,1,8};
        System.out.print("排序前数据为：");
        display(array);
        System.out.println("-----------------");
        sort(array);
        System.out.println("-----------------");
        System.out.print("排序后数据为：");
        display(array);
    }
}
