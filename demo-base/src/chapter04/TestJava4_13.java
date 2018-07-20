package chapter04;

/**
 * 以下程序说明了如何将一个二维数组作为参数传递到方法中
 * Created by Administrator on 2018/7/20.
 */
public class TestJava4_13 {

    public static void main(String[] args) {
        int[][] a = {{51, 38, 22, 12, 34}, {72, 64, 19, 31}};
        print_mat(a);
    }

    public static void print_mat(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] + "\t");
            System.out.println();
        }
    }
}
