/**
 * Created by sheng on 2018/6/29.
 */
public class Test {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.method();

        DecoratorA decoratorA = new DecoratorA(component);
        decoratorA.methodA();
        decoratorA.method();

        DecoratorB decoratorB = new DecoratorB(decoratorA);
        decoratorB.methodB();
        decoratorB.method();
    }
}
