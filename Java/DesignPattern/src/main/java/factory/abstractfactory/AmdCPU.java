package factory.abstractfactory;

/**
 * @author      xuanc
 * @date        2020/2/26 上午10:57
 * @version     1.0
 */ 
public class AmdCPU implements CPU {

    private int pins = 0;

    public AmdCPU(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("AMD CPU pins: " + pins);
    }

}
