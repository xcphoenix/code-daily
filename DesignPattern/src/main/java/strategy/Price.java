package strategy;

/**
 * @author      xuanc
 * @date        2020/2/17 下午4:52
 * @version     1.0
 */ 
public class Price {

    private MemberStrategy strategy;

    public Price(MemberStrategy strategy) {
        this.strategy = strategy;
    }

    public double quote(double booksPrice) {
        return this.strategy.calPrice(booksPrice);
    }

}
