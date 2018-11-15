package abstractfactory;

/**
 * Created by sheng on 2018/10/17.
 */
public class IntelFactory extends AbstractFactory {

    @Override
    public Cpu createCpu() {
        return new IntelCpu(755);
    }

    @Override
    public Mainboard createMainboard() {
        return new IntelMainboard(755);
    }
}
