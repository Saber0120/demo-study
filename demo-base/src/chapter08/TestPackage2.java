package chapter08;

import chapter08.demo.Person;

/**
 * import语句的使用
 * 当要访问不同包下的类的方法时，需要将该方法声明为public的
 * Created by sheng on 2018/7/31.
 */
public class TestPackage2 {

    public static void main(String[] args) {
        Person p = new Person();
        p.talk();
    }
}
