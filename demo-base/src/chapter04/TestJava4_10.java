package chapter04;

/**
 * 以下的程序说明了方法的使用
 * Created by Administrator on 2018/7/20.
 */
public class TestJava4_10 {

    public static void main(String[] args) {
        double num;
        num = show_length(22, 19);
        System.out.println("对角线长度为：" + num);
    }

    private static double show_length(int m, int n) {
        return Math.sqrt(m * m + n * n);    //  Math.sqrt(n)：将n开根号
    }
}
