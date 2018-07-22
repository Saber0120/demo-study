package chapter05;

/**
 * 未使用静态变量
 * 每个Person5对象都有city属性，如果想要修改，则要改n遍，如果用static来修饰，则只需修改一次
 * Created by Administrator on 2018/7/21.
 */
public class TestStaticDemo1 {

    public static void main(String[] args) {
        Person5 p1 = new Person5("张三", 22, "中国");
        Person5 p2 = new Person5("李四", 23, "中国");
        Person5 p3 = new Person5("王五", 24, "中国");

        p1.talk();
        p2.talk();
        p3.talk();
    }
}

class Person5 {
    String name;
    int age;
    String city;

    public Person5() {
    }

    public Person5(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    void talk() {
        System.out.println("我叫 " + name + ", 今年 "  + age + " 岁, 来自 " + city);
    }
}
