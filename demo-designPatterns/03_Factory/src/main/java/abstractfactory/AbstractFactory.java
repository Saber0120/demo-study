package abstractfactory;

/**
 * Created by sheng on 2018/10/17.
 */
public abstract class AbstractFactory {

    public abstract Cpu createCpu();

    public abstract Mainboard createMainboard();
}
