package book.chapter2;

import book.annotation.ThreadSafe;
import book.chapter2.base.Servlet;
import book.chapter2.base.ServletRequest;
import book.chapter2.base.ServletResponse;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author      xuanc
 * @date        2020/2/1 下午5:38
 * @version     1.0
 */ 
@ThreadSafe
public class CountingFactorizer implements Servlet {

    private final AtomicLong count = new AtomicLong(0);
    
    public long getCount() {
        return count.get();
    }
    
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(resp, factors);
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[] {};
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return BigInteger.ONE;
    }

}
