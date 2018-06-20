package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by sheng on 2018/6/20.
 */
public class TestProxy implements InvocationHandler {

    private Object source;

    public TestProxy(Object source) {
        this.source = source;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("method".equals(method.getName())) {
            System.out.println("other method");
        }
        // 不一定要实现相同的接口，需要添加下面两行代码，否则调用method.invoke即可
        Method sourceMethod = source.getClass().getDeclaredMethod(method.getName() + "Test", method.getParameterTypes());
        sourceMethod.setAccessible(true);
        Object result = sourceMethod.invoke(source, args);
        return result;
    }
}
