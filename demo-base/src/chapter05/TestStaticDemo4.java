package chapter05;

/**
 * 静态方法
 * static属性可以被static类型的方法使用，也可以在非static类型的方法使用；
 * 非static属性不可以被static类型的方法使用
 * Created by Administrator on 2018/7/22.
 */
public class TestStaticDemo4 {

    public static void main(String[] args) {
        Person8 p1 = new Person8("张三", 22);
        Person8 p2 = new Person8("李四", 23);
        Person8 p3 = new Person8("王五", 24);

        p1.talk();
        p2.talk();
        p3.talk();

        System.out.println("修改后：");
        Person8.setCity("美国"); //  类名.静态方法()：调用静态方法
        p1.talk();
        p2.talk();
        p3.talk();
    }
}

class Person8 {
    String name;
    int age;
    private static String city = "中国";

    public Person8() {
    }

    public Person8(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void setCity(String city) {
        city = city;
    }

    void talk() {
        System.out.println("我叫 " + name + ", 今年 "  + age + " 岁, 来自 " + city);
    }
}