package chapter06;

/**
 * 复写Object中的equals()
 * equals()用于比较对象是否相等
 * Created by sheng on 2018/7/31.
 */
public class TestOverEquals {

    public static void main(String[] args) {
        Person13 p1 = new Person13("张三", 24);
        Person13 p2 = new Person13("张三", 24);
        //  p1、p2指向不同的内存地址，在不同的内存空间，所以不相等
        System.out.println(p1.equals(p2) ? "p1、p2是同一个人" : "p1、p2不是同一个人");
    }
}

class Person13 {

    String name;

    int age;

    public Person13(String name, int age) {
        this.name = name;
        this.age = age;
    }
}