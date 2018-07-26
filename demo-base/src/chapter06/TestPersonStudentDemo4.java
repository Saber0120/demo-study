package chapter06;

/**
 * super 关键字的使用
 * super 主要的功能是完成子类调用父类中的内容
 * 用 super 调用父类中的构造方法，只能放在程序的第一行。
 * super 也可以调用父类中的属性或方法。不用放在第一行。
 * Created by sheng on 2018/7/26.
 */
public class TestPersonStudentDemo4 {

    public static void main(String[] args) {
        Student2 student = new Student2("张三", 22);
        student.school = "南信大";

        System.out.println("姓名：" + student.name + "，年龄：" + student.age + "，学校：" + student.school);
    }
}

class Person2 {

    String name;

    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void talk() {
        System.out.println("我叫：" + this.name + "，年龄：" + this.age);
    }
}

class Student2 extends Person2 {

    String school;

    public Student2(String name, int age) {
        super(name, age);
        //  以下三个super用this也可以，因为父类中并没有限制它们的访问权限，
        //  如果父类中设置了private权限，则不能直接使用父类的属性和方法，但可以隐式的调用，见demo6
        super.talk();
        super.name = "李四";
        super.age = 25;
    }
}