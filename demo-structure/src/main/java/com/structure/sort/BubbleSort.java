package com.structure.sort;

/**
 * 冒泡排序：两两比较，将最大的放到最后
 * Created by sheng on 2018/11/14.
 */
public class BubbleSort {

    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j+1]) {
                    array[j] += array[j+1];
                    array[j+1] = array[j] - array[j+1];
                    array[j] -= array[j+1];
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
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
