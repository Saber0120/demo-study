package chapter05;

/**
 * Created by Administrator on 2018/7/21.
 */
public class TestStaticDemo2 {

    public static void main(String[] args) {
        Person6 p1 = new Person6("张三", 22);
        Person6 p2 = new Person6("李四", 23);
        Person6 p3 = new Person6("王五", 24);

        p1.talk();
        p2.talk();
        p3.talk();

        System.out.println("修改后：");
        p1.city = "美国"; //  只需要修改一次，其他对象中的属性也都修改了
        p1.talk();
        p2.talk();
        p3.talk();
    }
}

class Person6 {
    String name;
    int age;
    static String city = "中国";

    public Person6() {
    }

    public Person6(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void talk() {
        System.out.println("我叫 " + name + ", 今年 "  + age + " 岁, 来自 " + city);
    }
}