package decorator;

/**
 * @author      xuanc
 * @date        2020/2/20 上午10:28
 * @version     1.0
 */ 
public class Pancake implements IPancake {

    @Override
    public void cook() {
        System.out.println("的煎饼");
    }

}
