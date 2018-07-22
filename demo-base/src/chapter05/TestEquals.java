package chapter05;

/**
 * 对象的比较
 * Created by Administrator on 2018/7/21.
 */
public class TestEquals {

    public static void main(String[] args) {
        String str1 = new String("Java");
        String str2 = new String("Java");
        String str3 = str2; //  str3 也指向了 str2的引用

        //  这两个对象指向不同的内存空间，所以它们的内存地址是不一样的
        if (str1 == str2)
            System.out.println("str1 == str2");
        else
            System.out.println("str1 != str2");

        if (str2 == str3)
            System.out.println("str2 == str3");
        else
            System.out.println("str2 != str3");

    }
}
