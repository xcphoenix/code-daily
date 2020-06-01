package proxy.staticmode;

/**
 * real object
 *
 * @author      xuanc
 * @date        2020/2/14 下午4:40
 * @version     1.0
 */ 
public class TwelveMonkeysMovie implements Movie {

    @Override
    public void play() {
        System.out.println("playing... [12 Monkeys]");
    }

}
