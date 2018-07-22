package chapter05;

/**
 * Created by Administrator on 2018/7/21.
 */
public class StringDemo {

    public static void main(String[] args) {
        String str1 = "Java";   //  占用一个内存空间
        String str2 = new String("Java");   //  "Java"占用的和str1一样的内存空间，但是new之后就占用另一片内存空间
        String str3 = "Java";

        System.out.println("str1 == str2 ? " + (str1 == str2));
        System.out.println("str2 == str3 ? " + (str2 == str3));
        System.out.println("str1 == str3 ? " + (str1 == str3));
    }
}
