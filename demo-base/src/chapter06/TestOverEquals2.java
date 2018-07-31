package chapter06;

/**
 * Created by sheng on 2018/7/31.
 */
public class TestOverEquals2 {

    public static void main(String[] args) {
        Person14 p1 = new Person14("张三", 24);
        Person14 p2 = new Person14("张三", 24);
        //  p1、p2指向不同的内存地址，在不同的内存空间，所以不相等
        System.out.println(p1.equals(p2) ? "p1、p2是同一个人" : "p1、p2不是同一个人");
    }
}

class Person14 {

    String name;

    int age;

    public Person14(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        boolean temp = true;

        if (obj instanceof Person14) {
            Person14 p1 = this;
            Person14 p2 = (Person14) obj;
            if (!(p1.name.equals(p2.name) && (p1.age == p2.age))) {
                return false;
            }
        }

        return temp;
    }
}