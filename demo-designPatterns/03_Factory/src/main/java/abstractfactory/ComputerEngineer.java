package abstractfactory;

/**
 * Created by sheng on 2018/10/17.
 */
public class ComputerEngineer {

    private Cpu cpu = null;

    private Mainboard mainboard = null;

    public void makeComputer(AbstractFactory factory) {
        prepareHardwares(factory);
    }

    private void prepareHardwares(AbstractFactory factory) {
        this.cpu = factory.createCpu();
        this.mainboard = factory.createMainboard();

        cpu.calculate();
        mainboard.installCpu();
    }
}
