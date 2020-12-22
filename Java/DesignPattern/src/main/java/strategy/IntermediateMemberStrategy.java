package strategy;

/**
 * @author      xuanc
 * @date        2020/2/17 下午4:45
 * @version     1.0
 */ 
public class IntermediateMemberStrategy implements MemberStrategy {

    @Override
    public double calPrice(double booksPrice) {
        System.out.println("白银VIP: 9折");
        return booksPrice * 0.9;
    }

}
