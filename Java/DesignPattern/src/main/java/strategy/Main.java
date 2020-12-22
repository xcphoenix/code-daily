package strategy;

/**
 * @author      xuanc
 * @date        2020/2/17 下午4:53
 * @version     1.0
 */
public class Main {

    public static void main(String[] args) {
        // 客户端选择具体策略
        MemberStrategy strategy = new AdvancedMemberStrategy();
        Price price = new Price(strategy);

        double quote = price.quote(300);
        System.out.println("售价：" + quote);
    }

}
