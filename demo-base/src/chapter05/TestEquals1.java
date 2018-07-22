package chapter05;

/**
 * “==”是比较内存地址值的，“equals”是比较内容的
 * Created by Administrator on 2018/7/21.
 */
public class TestEquals1 {

    public static void main(String[] args) {
        String str1 = new String("Java");
        String str2 = new String("Java");
        String str3 = str2;

        if (str1.equals(str2))
            System.out.println("str1 equals str2");
        else
            System.out.println("str1 not equals str2");

        if (str2.equals(str3))
            System.out.println("str2 equals str3");
        else
            System.out.println("str2 not equals str3");
    }
}
