package abstractfactory;

/**
 * Created by sheng on 2018/10/17.
 */
public class AmdCpu implements Cpu {

    private int pins = 0;

    public AmdCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("AMD CPU的针脚数：" + this.pins);
    }
}
