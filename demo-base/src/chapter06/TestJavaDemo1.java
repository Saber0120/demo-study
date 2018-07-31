package chapter06;

/**
 * 多态性
 *
 * 1、向上转型
 * 子类实例化对象可以转换为父类对象，不需要强制转换，但是会丢失精度
 * 2、向下转型
 * 父类对象转换为子类对象，需要强制转换
 * 3、instanceof关键字
 * 判断某个类是否实现了某个接口或继承了某个类，也可以用来判断一个实例对象是否属于某个类
 * Created by sheng on 2018/7/31.
 */
public class TestJavaDemo1 {

    public static void main(String[] args) {
        //  向上转型
        Person12 p = new Student12();
        p.fun1();   //  3.Student{fun1()}
        p.fun2();   //  2.Person{fun2()}
//        p.fun3()  //  编译出错，不可调用非父类中的方法

        //  向下转型
        Person12 p1 = new Person12();
//        Student12 s1 = (Student12) p1;  //  运行时异常，因为这个类并不是由子类实例化的
        Student12 s = (Student12) p;    //  运行通过，因为p是由子类实例化的

        //  instanceof
        if (p instanceof Student12) {
            Student12 s2 = (Student12) p;
            s2.fun1();
        } else {
            p.fun2();
        }
    }
}

class Person12 {

    void fun1() {
        System.out.println("1.Person{fun1()}");
    }

    void fun2() {
        System.out.println("2.Person{fun2()}");
    }
}

class Student12 extends Person12 {

    @Override
    void fun1() {
        System.out.println("3.Student{fun1()}");
    }

    void fun3() {
        System.out.println("4.Student{fun3()}");
    }
}