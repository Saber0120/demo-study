/**
 * Created by sheng on 2018/6/29.
 */
public class DecoratorB extends Decorator {

    public DecoratorB(Component component) {
        super(component);
    }

    public void methodB() {
        System.out.println("B额外的功能");
    }

    @Override
    public void method() {
        System.out.println("针对该方法的B包装");
        super.method();
        System.out.println("B包装结束");
    }
}
