/*
 * ContextDemo - Avatar.java
 * --------------------------
 * ContextDemo2 - for ServletContextListener
 */

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
// import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (
        urlPatterns = {"/avatar.view"}
        // for ServletContextEvent ------------------------------------
        // ,
        // initParams = {
        //         @WebInitParam(name = "AVATAR_DIR", value = "/avatars")
        // }
        // ............................................................
)
public class Avatar extends HttpServlet {
    private String AVATAR_DIR;

    @Override
    public void init() throws ServletException {
        // for ServletContextEvent ------------------------------------------
        // AVATAR_DIR = getInitParameter("AVATAR_DIR");
        AVATAR_DIR = (String) getServletContext().getAttribute("avatars");
        // ..................................................................
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // System.out.println(AVATAR_DIR);
        // AVATAR_DIR = getInitParameter("AVATAR_DIR");
        System.out.println(AVATAR_DIR);
        System.out.println(getServletConfig().getServletContext().getAttribute("avatars"));

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("" +
                "<!doctype html>\n" +
                "<html lang=\"zh\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>头像显示</title>\n" +
                "</head>" +
                "<body>");

        // 取得头像路径
        // 使用 HttpServlet 对象获取 ServletContext实例
        for (String avatar : getServletContext().getResourcePaths(AVATAR_DIR)) {
            // 返回的路径以应用环境为根目录，除去第一个'/'，让html以相对路径找到图片
            avatar = avatar.replaceFirst("/", "");
            out.println("   <img src='" + avatar + "'>");
        }

        out.println("" +
                "</body>" +
                "</html>");
        out.close();
    }
}