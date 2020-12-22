package factory.abstractfactory;

/**
 * @author      xuanc
 * @date        2020/2/26 上午11:00
 * @version     1.0
 */ 
public class AmdMainBoard implements MainBoard {

    private int cpuHoles = 0;

    public AmdMainBoard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("AMD MainBoard cpuHoles: " + cpuHoles);
    }

}
