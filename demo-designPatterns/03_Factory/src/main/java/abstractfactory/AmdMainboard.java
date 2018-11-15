package abstractfactory;

/**
 * Created by sheng on 2018/10/17.
 */
public class AmdMainboard implements Mainboard {

    private int cpuHoles = 0;

    public AmdMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCpu() {
        System.out.println("AMD 主板的CPU插槽数：" + this.cpuHoles);
    }
}
