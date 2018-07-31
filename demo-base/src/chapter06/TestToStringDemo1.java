package chapter06;

/**
 * Object 类的tostring()
 * Created by sheng on 2018/7/31.
 */
public class TestToStringDemo1 {

    public static void main(String[] args) {
        Person7 p = new Person7();
        System.out.println(p);  //  chapter06.Person7@1540e19d

        Person8 p8 = new Person8();
        System.out.println(p8); //  我叫 张三, 今年 24 岁了！
    }
}

class Person7 extends Object {

    String name;

    int age;
}

class Person8 {

    String name = "张三";

    int age = 24;

    @Override
    public String toString() {
        return "我叫 " + name + ", 今年 " + age + " 岁了！";
    }
}