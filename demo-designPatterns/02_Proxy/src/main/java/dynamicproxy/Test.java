package dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * Created by sheng on 2018/6/20.
 */
public class Test {

    public static void main(String[] args) {
        ITest iTest = (ITest) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {ITest.class}, new TestProxy(new TestReal()));
        iTest.method();
        iTest.method1();
    }
}
