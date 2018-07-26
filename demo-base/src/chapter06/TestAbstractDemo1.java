package chapter06;

/**
 * 抽象类
 * 1、必须用abstract修饰类和抽象方法
 * 2、不能被实例化
 * 3、抽象方法只需要声明，不需要实现
 * 4、有抽象方法的类必须被声明为抽象类，抽象类的子类必须实现所有抽象方法，否则这个子类还是抽象类
 * Created by Administrator on 2018/7/26.
 */
public class TestAbstractDemo1 {

    public static void main(String[] args) {
        Student6 s = new Student6("张三", 18, "学生");
        Worker6 w = new Worker6("李四", 18, "工人");

        System.out.println(s.talk());
        System.out.println(w.talk());
    }
}

abstract class Person6 {

    String name;

    int age;

    String occupation;

    abstract String talk();
}

class Student6 extends Person6 {

    public Student6(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    @Override
    String talk() {
        return "学生：" + this.name + "，年龄：" + this.age + "，职业：" + this.occupation;
    }
}

class Worker6 extends Person6 {

    public Worker6(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    @Override
    String talk() {
        return "工人：" + this.name + "，年龄：" + this.age + "，职业：" + this.occupation;
    }
}