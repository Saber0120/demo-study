package chapter03;

/**
 * 字符类型也可以直接赋给数值，下面的这段程序就是采用这种赋值方式
 * Created by sheng on 2018/7/20.
 */
public class TestJava3_6 {

    public static void main(String[] args) {
        char ch1 = 97;
        char ch2 = 'a';

        System.out.println("ch1 = " + ch1); //  ch1 = a
        System.out.println("ch2 = " + ch2); //  ch2 = a
    }
}
