package decorator;

/**
 * 装饰类
 *
 * @author      xuanc
 * @date        2020/2/20 上午10:28
 * @version     1.0
 */ 
public abstract class PancakeDecorator implements IPancake {

    private IPancake pancake;

    public PancakeDecorator(IPancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public void cook() {
        if (this.pancake != null) {
            pancake.cook();
        }
    }

}
