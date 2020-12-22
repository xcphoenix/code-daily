package top.xcphoenix.algorithm.lcof;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author      xuanc
 * @date        2020/3/1 下午4:57
 * @version     1.0
 */
public class Code14 {

    @Test
    public void test() {
        for (int i = 0 ; i < 150; i++) {
            System.out.println("i = " + i + ", " + cuttingRope(i));
        }
    }

    static BigInteger[] record = new BigInteger[1002];

    static BigInteger cuttingRope(int n) {
        if (n <= 2) {
            return new BigInteger("1");
        }
        BigInteger max = new BigInteger("-1");
        for (int m = 1; m < n; m++) {
            max = max.max(new BigInteger(String.valueOf(n - m)).multiply(record[m] != null ? record[m] : cuttingRope(m)));
            max = max.max(new BigInteger(String.valueOf(m * (n - m))));
        }
        return record[n] = max.mod(new BigInteger("1000000007"));
    }

}
