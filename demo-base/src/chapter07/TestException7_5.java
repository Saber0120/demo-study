package chapter07;

/**
 * 指定方法抛出异常
 *
 * Created by sheng on 2018/7/31.
 */
public class TestException7_5 {

    public static void main(String[] args) {
        Test t = new Test();
        //  这里需要调用try-catch来处理异常
        try {
            t.division();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Test {

    void division() throws Exception {
        int a = 4, b = 0;
        System.out.println(a / b);
    }
}