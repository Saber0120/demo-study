package chapter08;

/**
 * 包的概念：
 * 处理相同的类名的问题
 * Created by sheng on 2018/7/31.
 */
public class TestPackage1 {

    public static void main(String[] args) {
        Person p = new Person();
        p.talk();
    }
}

class Person {

    void talk() {
        System.out.println("Person{talk()}");
    }
}