package decorator;

/**
 * @author      xuanc
 * @date        2020/2/20 上午10:32
 * @version     1.0
 */ 
public class HamDecorator extends PancakeDecorator {

    public HamDecorator(IPancake pancake) {
        super(pancake);
    }

    @Override
    public void cook() {
        System.out.println("加了一根火腿,");
        super.cook();
    }
}
