/**
 * Created by sheng on 2018/6/29.
 */
public class DecoratorA extends Decorator {

    public DecoratorA(Component component) {
        super(component);
    }

    public void methodA() {
        System.out.println("A扩展功能");
    }

    @Override
    public void method() {
        System.out.println("针对该方法加一层A包装");
        super.method();
        System.out.println("A包装结束");
    }
}
