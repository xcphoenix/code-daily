package strategy;

/**
 * @author      xuanc
 * @date        2020/2/17 下午4:40
 * @version     1.0
 */ 
public class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double calPrice(double booksPrice) {
        System.out.println("无折扣");
        return booksPrice;
    }

}
