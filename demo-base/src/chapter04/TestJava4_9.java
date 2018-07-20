package chapter04;

/**
 * 以下程序是关于方法的返回类型是整型的范例
 * Created by Administrator on 2018/7/20.
 */
public class TestJava4_9 {

    public static void main(String[] args) {
        int num;
        num = star(7);
        System.out.println(num + " stars printed");
    }

    public static int star(int n) {
        for (int i = 0; i < (2 * n); i++)
            System.out.print("*");
        System.out.println();
        return (2 * n);
    }
}
