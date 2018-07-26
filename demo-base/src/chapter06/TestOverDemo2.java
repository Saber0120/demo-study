package chapter06;

/**
 * 调用父类中被复写的方法
 * Created by Administrator on 2018/7/26.
 */
public class TestOverDemo2 {

    public static void main(String[] args) {
        Student5 s = new Student5("李四", 18, "nuist");
        System.out.println(s.talk());
    }
}

class Person5 {

    String name;

    int age;

    String talk() {
        return "我叫：" + this.name + "，年龄：" + this.age;
    }
}

class Student5 extends Person5 {

    String school;

    public Student5(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    String talk() {
        return super.talk() + "，在 " + this.school + " 上学";
    }
}