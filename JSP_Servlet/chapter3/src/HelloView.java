/*
* 简单的 Model 2 架构程序
* */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello.view")
public class HelloView extends HttpServlet {
    private String htmlTemplate =
                    "<html>" +
                    "<head>" +
                    "<meta charset=UTF-8>" +
                        "<title>%s</title>" +
                    "</head>" +
                    "<body>" +
                        "<h1>%s</h1>" +
                    "</body>" +
                    "</html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String user = req.getParameter("user");  // 获得请求参数
        String message = (String) req.getAttribute("message");  // 取得请求属性
        String html = String.format(htmlTemplate, user, message);
        // 类似 C: sprintf(...)
        // format(String format, Object... args) 新字符串使用本地语言环境，制定字符串格式和参数生成格式化的新字符串。
        resp.getWriter().print(html);
    }
}