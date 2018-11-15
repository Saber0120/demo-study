package abstractfactory;

/**
 * Created by sheng on 2018/10/17.
 */
public class IntelMainboard implements Mainboard {

    private int cpuHoles = 0;

    public IntelMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCpu() {
        System.out.println("INTEL主板的CPU插槽孔数：" + this.cpuHoles);
    }
}
