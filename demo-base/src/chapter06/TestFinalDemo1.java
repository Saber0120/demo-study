package chapter06;

/**
 * final关键字
 * 1、final修饰的类不能被继承
 * 2、final修饰的方法不能被复写
 * 3、final修饰的变量（成员或局部变量）只能被赋值一次，为常量
 * Created by sheng on 2018/7/31.
 */
public class TestFinalDemo1 {

    public static void main(String[] args) {
        final int i = 10;
//        i++;  //  编译报错
    }
}

final class Person9 {

}

//  编译报错，不能被继承
//class Student9 extends Person9 {
//
//}

class Person10 {

    final void talk() {

    }
}

class Student10 extends Person10 {

    //  编译报错，不能复写
//    void talk() {
//
//    }
}