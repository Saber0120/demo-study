package chapter05;

/**
 * 创建多个新对象
 * Created by Administrator on 2018/7/20.
 */
public class TestPersonDemo1 {

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();

        p1.name = "张三";
        p1.age = 28;

        p2.name = "李四";
        p2.age = 20;

        p1.talk();
        p2.talk();
    }
}
