package abstractfactory;

/**
 * Created by sheng on 2018/10/17.
 */
public class IntelCpu implements Cpu {

    private int pins = 0;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("INTEL CPU的针脚数：" + this.pins);
    }
}
