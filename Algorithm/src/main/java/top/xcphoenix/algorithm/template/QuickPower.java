package top.xcphoenix.algorithm.template;

/**
 * @author      xuanc
 * @date        2020/3/23 下午8:43
 * @version     1.0
 */ 
public class QuickPower {

    private long mod;

    public QuickPower(long mod) {
        this.mod = mod;
    }

    public int quickPower(int a, int b) {
        long ans = 1;
        a %= mod;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = (ans * a) % mod;
            }
            b >>= 1;
            a = (int) ((a * a) % mod);
        }
        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        QuickPower quickPower = new QuickPower(1000);
        System.out.println(quickPower.quickPower(3, 100));
    }

}
