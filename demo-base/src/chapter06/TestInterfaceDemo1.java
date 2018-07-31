package chapter06;

/**
 * 接口
 * 1、接口里的数据成员必须初始化，且为常量
 * 2、接口中的所有方法均为抽象方法，只需要声明
 * 3、jkd8中允许定义static方法和default方法
 * 4、接口可以通过继承来派生出新的接口
 * 5、一个类只能继承一个类，但可以实现多个接口
 * Created by sheng on 2018/7/31.
 */
public class TestInterfaceDemo1 {

    public static void main(String[] args) {
        Student11 s = new Student11();
        System.out.println(s.talk());

        Person11.staticMethod();    //  直接通过接口.static方法来调用接口的static方法
        s.defaultMethod();  //  通过对象.default方法来调用接口的default方法
    }
}

interface Person11 {

    String name = "张三";

    int age = 22;

    static void staticMethod() {
        System.out.println("接口中可以有static方法");
    }

    default void defaultMethod() {
        System.out.println("接口中可以有default方法！");
    }

    String talk();
}

class Student11 implements Person11 {

    @Override
    public String talk() {
        return "我叫 " + name + ", 今年 " + age + " 岁了！";
    }
}