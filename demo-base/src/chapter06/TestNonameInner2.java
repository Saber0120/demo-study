package chapter06;

/**
 * Created by sheng on 2018/7/31.
 */
public class TestNonameInner2 {

    public static void main(String[] args) {
        B2 b = new B2();
        b.test();
    }
}

interface A2 {

    void fun1();
}

class B2 {

    int i = 10;

    void get(A1 a) {
        a.fun1();
    }

    void test() {
        //  把一个实现类传给了get方法
        this.get(new A1() {
            @Override
            public void fun1() {
                System.out.println(i);
            }
        });
    }
}