/*
 * ContextDemo2 - ContextParameterReader.java
 * ------------------------------------------
 * 多个@WebListener标注似乎不能指定顺序
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 使用@WebListener标注
// 没有设置初始参数的属性
// @WebListener
// 实现接口
public class test implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        // 取得ServletContext
        ServletContext context = sce.getServletContext();
        context.setAttribute("other", "/avatars");
    }
    public void contextDestroyed(ServletContextEvent sce) {}
}