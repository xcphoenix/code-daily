package decorator;

/**
 * @author      xuanc
 * @date        2020/2/20 上午10:35
 * @version     1.0
 */ 
public class Main {

    public static void main(String[] args) {
        System.out.println("==> 都加！");
        IPancake pancake = new Pancake();
        IPancake pancakeWithEgg = new EggDecorator(pancake);
        IPancake pancakeWithEggAndHam = new HamDecorator(pancakeWithEgg);
        IPancake pancakeWithEggAndHamAndLettuce = new LettuceDecorator(pancakeWithEggAndHam);
        pancakeWithEggAndHamAndLettuce.cook();

    }

}

