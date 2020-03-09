package factory.abstractfactory;

/**
 * @author      xuanc
 * @date        2020/2/26 上午11:02
 * @version     1.0
 */ 
public class IntelMainboard implements MainBoard {

    private int cpuHoles = 0;

    public IntelMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("Intel MainBoard cpu holes: " + cpuHoles);
    }

}
