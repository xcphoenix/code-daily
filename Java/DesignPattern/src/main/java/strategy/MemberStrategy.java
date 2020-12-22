package strategy;

/**
 * @author      xuanc
 * @date        2020/2/17 下午4:36
 * @version     1.0
 */ 
public interface MemberStrategy {

    /**
     * 计算折扣
     *
     * @param booksPrice 图书原价
     * @return 打折后的价格
     */
    double calPrice(double booksPrice);

}
