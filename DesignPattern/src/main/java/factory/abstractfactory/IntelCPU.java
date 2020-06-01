package factory.abstractfactory;

/**
 * @author      xuanc
 * @date        2020/2/26 上午10:59
 * @version     1.0
 */ 
public class IntelCPU implements CPU {

    private int pins = 0;

    public IntelCPU(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("Intel CPU pins: " + pins);
    }

}
