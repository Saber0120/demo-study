package staticproxy;

/**
 * Created by sheng on 2018/6/20.
 */
public class TestClassProxy extends ITestClass {

    private TestClass testClass;

    public TestClassProxy(TestClass testClass) {
        this.testClass = testClass;
    }

    public void method1() {
        System.out.println("before method1");
        testClass.method1();
        System.out.println("after method1");
    }

    public void method2() {
        System.out.println("before method2");
        testClass.method2();
        System.out.println("after method2");
    }
}
