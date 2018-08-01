package chapter10.sub07;

import java.io.PrintWriter;

/**
 * 打印流
 * 向屏幕输出
 * Created by sheng on 2018/8/1.
 */
public class SystemPrintDemo {

    public static void main(String[] args) {
        PrintWriter out = null;
        //  通过System.out为PrintWriter实例化
        out = new PrintWriter(System.out);
        //  在屏幕输出
        out.print("aha");
        out.close();
    }
}
