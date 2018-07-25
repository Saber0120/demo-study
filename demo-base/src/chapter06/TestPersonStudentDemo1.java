package chapter06;

/**
 * 子类对象的实例化过程
 * Created by Administrator on 2018/7/25.
 */
public class TestPersonStudentDemo1 {

    public static void main(String[] args) {
        //  子类对象在实例化时会默认先去调用父类中的无参构造方法，之后再调用本类中的相应构造方法。
        Student1 s = new Student1();
    }
}

class Person1 {
    String name;
    int age;

    public Person1() {
        System.out.println("1.父类构造方法");
    }
}

class Student1 extends Person1 {
    String school;

    public Student1() {
        //super();  //  这里隐含了这样一条语句，且父类必须有一无参构造方法，否则编译不通过
        System.out.println("2.子类构造方法");
    }
}