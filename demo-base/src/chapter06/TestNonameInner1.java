package chapter06;

/**
 * 匿名内部类
 * Created by sheng on 2018/7/31.
 */
public class TestNonameInner1 {

    public static void main(String[] args) {
        B1 b = new B1();
        b.test();
    }
}

interface A1 {

    void fun1();
}

class B1 {

    int i = 10;

    class C1 implements A1 {

        @Override
        public void fun1() {
            System.out.println(i);
        }
    }

    void get(A1 a) {
        a.fun1();
    }

    void test() {
        this.get(new C1());
    }
}