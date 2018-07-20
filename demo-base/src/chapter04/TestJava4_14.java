package chapter04;

/**
 * 以下的程序说明了方法中返回一个二维数组的实现过程
 * Created by Administrator on 2018/7/20.
 */
public class TestJava4_14 {

    public static void main(String[] args) {
        int[][] a = {{51, 38, 82, 12, 34}, {72, 64, 19, 31}};
        int[][] b = new int[2][5];
        b = add(a);
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++)
                System.out.print(b[i][j] + "\t");
            System.out.println();
        }

    }

    public static int[][] add(int[][] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                a[i][j] += 10;

        return a;
    }
}
