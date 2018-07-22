package chapter05;

/**
 * Created by Administrator on 2018/7/22.
 */
public class TestSingleDemo2 {

    public static void main(String[] args) {
        Person10 p = null;
        p = Person10.getP();    //  无论声明多少个对象，最终都是得到相同的引用
        System.out.println(p.name);
    }
}

class Person10 {

    String name;

    private final static Person10 p = new Person10();   //  在类内部实例化，可以调用私有构造方法，final表示只能实例化一次

    //  封装构造方法
    private Person10() {
        this.name = "张三";
    }

    public static Person10 getP() {
        return p;
    }
}