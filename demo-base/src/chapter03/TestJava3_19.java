package chapter03;

/**
 * 下面这段程序是对与操作进行的说明，返回值为布尔类型
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_19 {

    public static void main(String[] args) {
        int a = 56;

        if ((a < 0) || (a > 100))
            System.out.println("输入的数据有误！");

        if ((a > 50) && (a < 60))
            System.out.println("准备补考吧！");
    }
}
