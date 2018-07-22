package chapter05;

/**
 * 构造方法私有
 * Created by Administrator on 2018/7/22.
 */
public class TestSingleDemo1 {

    private TestSingleDemo1() {
        System.out.println("private TestSingleDemo1()");
    }

    public static void main(String[] args) {
        new TestSingleDemo1();  //  私有的构造方法只能被本类中被调用
    }
}


