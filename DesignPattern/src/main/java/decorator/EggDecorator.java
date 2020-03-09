package decorator;

/**
 * @author      xuanc
 * @date        2020/2/20 上午10:31
 * @version     1.0
 */ 
public class EggDecorator extends PancakeDecorator {

    public EggDecorator(IPancake pancake) {
        super(pancake);
    }

    @Override
    public void cook() {
        System.out.println("加了一个鸡蛋,");
        super.cook();
    }

}
