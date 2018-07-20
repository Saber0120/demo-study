package chapter04;

/**
 * 二维数组的使用说明，这里采用静态赋值的方式
 * Created by sheng on 2018/7/20.
 */
public class TestJava4_6 {

    public static void main(String[] args) {
        int i, j, sum = 0;
        int[][] num = {{30, 35, 26, 32}, {33, 34, 30}}; // 声明数组并设置初值

        for (i = 0; i < num.length; i++) {
            System.out.print("第 "  + (i + 1) + " 个数组元素为：\t");
            for (j = 0; j < num[i].length; j++) {
                System.out.print(num[i][j] + "\t");
                sum += num[i][j];
            }
            System.out.println();
        }
        System.out.println("所有元素之和为：" + sum);
    }
}
