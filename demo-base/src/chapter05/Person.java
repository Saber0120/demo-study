package chapter05;

/**
 * Created by Administrator on 2018/7/20.
 */
public class Person {

    String name;

    int age;

    public Person() {
        System.out.println("new Person()");
    }

    public Person(String name, int age) {
        this(); //  调用构造方法
        this.name = name;
        this.age = age;
    }

    void talk() {
        System.out.println("我叫 " + name + ", 今年 "  + age + " 岁了");
    }

    boolean compare(Person p) {
        if (this.name.equals(p.name) && this.age == p.age) {
            return true;
        } else {
            return false;
        }
    }
}
