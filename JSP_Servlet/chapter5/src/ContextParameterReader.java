/*
 * ContextDemo2 - ContextParameterReader.java
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 使用@WebListener标注
// 没有设置初始参数的属性
@WebListener
// 实现接口
public class ContextParameterReader implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        // 取得ServletContext
        ServletContext context = sce.getServletContext();
        // 取得初始化参数
        String avatars = context.getInitParameter("AVATAR_DIR");
        // 设置为 ServletContext 属性，在Web应用存活期一直存在，除非使用ServletContext.removeAttribute()主动移除
        context.setAttribute("avatars", avatars);
    }
    public void contextDestroyed(ServletContextEvent sce) {}
}