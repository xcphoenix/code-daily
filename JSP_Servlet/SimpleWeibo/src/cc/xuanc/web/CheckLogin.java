package cc.xuanc.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * ClassName    SimpleWeibo-CheckLogin
 * Description  利用过滤器检测用户是否已经登录
 * @author      xuanc
 * @date        19-3-5 下午6:26
 * @version     1.0
 */
@WebFilter(
        urlPatterns = {
                "/member.jsp", "/logout.do", "/addMessage.do", "/deleteMessage.do"
        },
        initParams = {
              @WebInitParam(name = "LOGIN_VIEW", value = "index.jsp")
        }
)
public class CheckLogin implements Filter{
    private String loginView;

    @Override
    public void init(FilterConfig config) throws ServletException {
        // 获取初始参数来设置登录页面
        this.loginView = config.getInitParameter("LOGIN_VIEW");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest req = (HttpServletRequest) request;
        // 如果已经登录正常执行
        if (req.getSession().getAttribute("login") != null) {
            chain.doFilter(request, response);
        }
        // 未登录重定向至登录页面
        else {
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.sendRedirect(loginView);
        }
    }

    @Override
    public void destroy() {}
}
