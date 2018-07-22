package chapter05;

/**
 * 计数 产生了多少个实例对象
 * Created by Administrator on 2018/7/22.
 */
public class TestStaticDemo3 {

    public static void main(String[] args) {
        new Person7();
        new Person7();
    }
}

class Person7 {
    static int count = 0;

    public Person7() {
        count++;
        System.out.println("产生了 " + count + " 个对象！");
    }
}