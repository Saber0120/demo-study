package chapter06;

/**
 * 继承的基本概念
 * UML图：一根实线和一个空心三角形，从子类指向父类，来表示子类继承父类
 * Created by Administrator on 2018/7/25.
 */
public class TestPersonStudentDemo {

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "张三";
        student.age = 22;
        student.school = "Nuist";

        System.out.println("姓名：" + student.name + "，年龄：" + student.age + "，学校：" + student.school);
    }
}

class Person {
    String name;
    int age;
}

class Student extends Person {
    String school;
}
