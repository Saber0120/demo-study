/**
 * Created by sheng on 2018/6/29.
 */
public abstract class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        super();
        this.component = component;
    }

    public void method() {
        component.method();
    }
}
