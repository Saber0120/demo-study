package chapter06;

/**
 * 接口的继承
 * 接口可以通过extends来继承其它接口，且可以多继承
 * Created by sheng on 2018/7/31.
 */
public class TestInterfaceDemo2 {

    public static void main(String[] args) {
        D d = new D();
        d.talkI();
        d.talkJ();
        d.talkK();
    }
}

interface A {

    int i = 10;

    void talkI();
}

interface B {

    int j = 20;

    void talkJ();
}

interface C extends A,B {

    int k = 30;

    void talkK();
}

class D implements C {

    @Override
    public void talkI() {
        System.out.println("i = " + i);
    }

    @Override
    public void talkJ() {
        System.out.println("j = " + j);
    }

    @Override
    public void talkK() {
        System.out.println("k = " + k);
    }
}