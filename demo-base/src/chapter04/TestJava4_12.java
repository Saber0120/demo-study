package chapter04;

/**
 * 一维数组作为参数来传递，这里的一维数组采用静态方式赋值
 * Created by Administrator on 2018/7/20.
 */
public class TestJava4_12 {

    public static void main(String[] args) {
        int[] score = {7, 3, 8, 19, 6, 22};
        largest(score);
    }

    public static void largest(int[] a) {
        int tmp = a[0];
        for (int i = 0; i < a.length; i++)
            if (a[i] > tmp)
                tmp = a[i];
        System.out.println("数组a的最大值为：" + tmp);
    }
}
