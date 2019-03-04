package cc.xuanc.web;

import cc.xuanc.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ClassName    SimpleWeibo-WeiboListener
 * Description  监听器－应用程序初始化时创建
 * @author      xuanc
 * @date        19-3-4 下午7:55
 * @version     1.0
 */
@WebListener
public class WeiboListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        // 获取初始参数值
        String user = context.getInitParameter("JDBC_USERS");
        String password = context.getInitParameter("JDBC_PASSWORD");
        String url = context.getInitParameter("JDBC_URL");

        context.setAttribute("userService", new UserService(user, password, url));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}
