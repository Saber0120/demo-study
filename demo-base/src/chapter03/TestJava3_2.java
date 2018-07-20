package chapter03;

/**
 * 下面这段程序说明了值的可取范围的问题
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_2 {

    public static void main(String[] args) {
//        int num = 329852547553; //  声明一个长整型变量，超过了int的最大范围，改为long
        long num = 329852547553L;
        System.out.println("num = " + num);
    }
}
