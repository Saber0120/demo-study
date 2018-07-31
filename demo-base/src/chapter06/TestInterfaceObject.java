package chapter06;

/**
 * 接口对象的实例化
 * 接口只能由实现类来实例化，抽象类也是一样的
 * Created by sheng on 2018/7/31.
 */
public class TestInterfaceObject {

    public static void main(String[] args) {
        Person15 p = new Student15();
        p.fun1();
    }
}

interface Person15 {

    void fun1();
}

class Student15 implements Person15 {

    @Override
    public void fun1() {
        System.out.println("Student{fun1()}");
    }
}