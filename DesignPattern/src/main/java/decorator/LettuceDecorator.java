package decorator;

/**
 * @author      xuanc
 * @date        2020/2/20 上午10:33
 * @version     1.0
 */ 
public class LettuceDecorator extends PancakeDecorator {

    public LettuceDecorator(IPancake pancake) {
        super(pancake);
    }

    @Override
    public void cook() {
        System.out.println("加了一颗生菜,");
        super.cook();
    }
}
