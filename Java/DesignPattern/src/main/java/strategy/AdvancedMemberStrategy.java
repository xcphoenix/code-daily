package strategy;

/**
 * @author      xuanc
 * @date        2020/2/17 下午4:50
 * @version     1.0
 */ 
public class AdvancedMemberStrategy implements MemberStrategy {

    @Override
    public double calPrice(double booksPrice) {
        System.out.println("黄金VIP: 8折");
        return booksPrice * 0.8;
    }

}
