package staticproxy;

/**
 * Created by sheng on 2018/6/20.
 */
public class Test {

    public static void main(String[] args) {
        ITestClass iTestClass = new TestClassProxy(new TestClass());
        iTestClass.method1();
        iTestClass.method2();
    }
}
