package chapter04;

/**
 * 下面程序说明了三维数组的使用方法，要输出数组的内容需要采用三重循环
 * Created by sheng on 2018/7/20.
 */
public class TestJava4_7 {

    public static void main(String[] args) {
        int i, j, k, sum = 0;
        int[][][] a = {{{5, 1}, {6, 7}}, {{9, 4}, {8, 3}}}; // 声明数组并设置初值
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[i].length; j++) {
                for (k = 0; k < a[i][j].length; k++) {
                    System.out.print("a[" + i + "][" + j + "][" + k + "] = ");
                    System.out.println(a[i][j][k]);
                    sum += a[i][j][k];
                }
            }
        }
        System.out.println("所有元素之和为：" + sum);
    }
}
