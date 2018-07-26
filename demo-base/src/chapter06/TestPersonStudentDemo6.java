package chapter06;

/**
 * 限制子类的访问
 * 封装父类的属性，提供set方法来访问被封装属性的值
 * Created by sheng on 2018/7/26.
 */
public class TestPersonStudentDemo6 {

    public static void main(String[] args) {
        Student3 s = new Student3();
        s.setVal();
        s.talk();
    }
}

class Person3 {

    private String name;

    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void talk() {
        System.out.println("我叫：" + this.name + "，年龄：" + this.age);
    }
}

class Student3 extends Person3 {

    String school;

    void setVal() {
        super.setName("张三");
        super.setAge(24);
    }
}