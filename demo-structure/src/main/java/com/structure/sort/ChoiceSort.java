package com.structure.sort;

/**
 * 选择排序：选择最小的放到最前面
 * Created by sheng on 2018/11/14.
 */
public class ChoiceSort {

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                array[i] += array[min];
                array[min] = array[i] - array[min];
                array[i] -= array[min];
            }
            System.out.print("第" + (i + 1) + "轮排序后结果为：");
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
