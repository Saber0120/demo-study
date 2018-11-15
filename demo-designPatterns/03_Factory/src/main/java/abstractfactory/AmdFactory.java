package abstractfactory;

/**
 * Created by sheng on 2018/10/17.
 */
public class AmdFactory extends AbstractFactory {

    @Override
    public Cpu createCpu() {
        return new AmdCpu(938);
    }

    @Override
    public Mainboard createMainboard() {
        return new AmdMainboard(938);
    }
}
