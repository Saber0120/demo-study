package chapter05;

/**
 * 静态代码块
 * Created by Administrator on 2018/7/22.
 */
public class TestStaticDemo5 {

    static {
        System.out.println("TestStaticDemo5 的静态代码快执行");
    }

    public static void main(String[] args) {
        System.out.println("程序执行");
        new Person9();
        new Person9();
    }
}

class Person9 {

    static String name = "张三";

    public Person9() {
        System.out.println("Person9 的构造方法执行");
    }

    static {
        System.out.println("name = " + name);
        System.out.println("Person9 的静态代码块执行");
        name = "李四";
        System.out.println("name = " + name);
    }
}