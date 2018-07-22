package chapter05;

/**
 * Created by Administrator on 2018/7/20.
 */
public class TestPersonDemo3_1 {

    public static void main(String[] args) {
        Person1 p = new Person1();
        //  此时不能通过 对象.属性 的方式进行赋值
        //  p.name = "张三";
        //  p.age = 22;
    }
}

class Person1 {
    private String name;
    private int age;

    public void talk() {
        System.out.println("我叫 " + name + ", 今年 "  + age + " 岁了");
    }
}
