package cc.xuanc.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebFilter;


/**
 * ClassName    SimpleWeibo-EscapeFilter
 * Description  过滤器－替换html字符
 * @author      xuanc
 * @date        19-3-6 下午6:22
 * @version     1.0
 */
@WebFilter("/*")
public class EscapeFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        EscapeWrapper requestWrapper = new EscapeWrapper((HttpServletRequest) request);
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {}
}
