package chapter05;

/**
 * 类的封装性
 * 年龄等于-25，显然是不合理的，所以在开发中往往都要将属性进行封装，如TestPersonDemo3_1
 * Created by Administrator on 2018/7/20.
 */
public class TestPersonDemo2 {

    public static void main(String[] args) {
        Person p = new Person();
        p.name = "张三";
        p.age = -25;
        p.talk();   //  我叫 张三, 今年 -25 岁了
    }
}
