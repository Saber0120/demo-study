package com.structure.recursion;

/**
 * 递归：
 * 1、从前有座山，山上有座庙，庙里有一个老和尚和一个小和尚，一天，老和尚给小和尚讲了一个故事，故事内容是“从前有座山，山上有座庙，庙里有一个老和尚和一个小和尚，一天，老和尚给小和尚讲了一个故事，故事内容......”
 * 2、程序调用自身，这种编程技巧称为递归
 * 3、三个要素：
 * 3.1、边界条件
 * 3.2、递归前进段
 * 3.3、递归返回段
 * 当边界条件不满足时，递归前进；当边界条件满足时，递归返回
 */
public class RecursionTest {

    public static void main(String[] args) {
        RecursionTest test = new RecursionTest();
        // System.out.println(test.getFactorialFor(5));
        // System.out.println(test.getFactorial(5));

        // int[] array = {11,22,33,44,55,66,77,88};
        // int key = 77;
        // System.out.println(test.findTwoPoint(array, key));
        // int key2 = 45;
        // System.out.println(test.findTwoPoint(array, key2));

        // int[] array = {11, 22, 33, 44, 55, 60, 66, 77, 88};
        // int key = 88;
        // System.out.println(test.findTwoPointSearch(array, key, 0, array.length - 1));
        // int key2 = 45;
        // System.out.println(test.findTwoPointSearch(array, key2, 0, array.length));

        move(4, "A", "B", "C");
    }

    /**
     * 一、求一个数的阶乘：n! = n*(n-1)*(n-2)*......1
     * 用for循环实现
     *
     * @param n
     * @return
     */
    public static int getFactorialFor(int n) {
        if (n < 0) {
            return -1;
        }
        int temp = 1;
        for (int i = 1; i <= n; i++) {
            temp = temp * i;
        }
        return temp;
    }

    /**
     * 二、阶乘：n! = n*(n-1)！
     * 使用递归实现，边界条件是n=0
     *
     * @param n
     * @return
     */
    public static int getFactorial(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            System.out.println(n + " != 1");
            return 1;
        } else {
            System.out.println(n);
            int temp = n * getFactorial(n - 1);
            System.out.println(n + " != " + temp);
            return temp;
        }
    }

    /**
     * 三、二分查找
     * 1、二分查找的数组一定是有序的
     * 2、找到返回数组下标，找不到返回-1
     */
    public static int findTwoPoint(int[] array, int key) {
        int start = 0;
        int last = array.length - 1;
        while (start <= last) {
            int mid = (last - start) / 2 + start;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                start = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 四、用递归实现二分查找
     * 1、边界条件是找到当前值或者查找的范围为空，否则将查找范围缩小一半
     */
    public static int findTwoPointSearch(int[] array, int key, int low, int high) {
        int mid = (high - low) / 2 + low;
        if (array[mid] == key) {
            return mid;
        } else if (low > high) {
            return -1;
        } else {
            if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            return findTwoPointSearch(array, key, low, high);
        }
    }

    /**
     * 五、分治算法
     * 1、某些问题需要处理的数据很多，或者求解过程相当复杂，使得直接求解法在时间上相当长，或者根本无法直接求出
     * 2、将问题分解成子问题，先找到子问题的解法后，在找到合适的方法，把它们组合成整个问题的解法
     * 3、如果子问题还较大，难以解决，继续分解成更小的子问题，直到可以直接求出解为止
     * 4、二分法就是一个分治算法的例子，分治算法通常是一个方法中含有两个对自身的递归调用，分别对应问题的两个部分
     */

    /**
     * 六、汉诺塔问题
     * 无论多少个盘子，都把它看成两个盘子，第N个盘子和第(N-1)个盘子~第1个盘子
     * 1、先将A塔座的第(N-1)~1个盘子放到中介塔座B，然后将第N个盘子放到目标塔座C
     * 2、B塔座有N-1个盘子，将第(N-2)~1个盘子放到中介塔座A，将第N-1个盘子放到目标塔座C
     * 3、以此类推，直到全部放到塔座C
     */
    public static void move(int dish, String from, String temp, String to) {
        if (dish == 1) {
            System.out.println("将第" + dish + "个盘子从塔座"  + from + "移到目标塔座" + to);
        } else {
            move(dish - 1, from, to, temp);
            System.out.println("将第" + dish + "个盘子从塔座"  + from + "移到目标塔座" + to);
            move(dish - 1, temp, from, to);
        }
    }
}
