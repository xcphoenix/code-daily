/*
 * FilterDemo　Performance
 */

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@WebFilter(
        filterName = "performance",
        urlPatterns = {"/*"}
)
// 实现 Filter 接口
public class PerformanceFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();    // Returns the current time in milliseconds
        chain.doFilter(request, response);
        config.getServletContext().log("Request process in " + (System.currentTimeMillis() - begin) + " milliseconds");
        // 计算花费的时间
    }

    @Override
    public void destroy() {}
}