/*
 * SessionListenerDemo - Welcome.java
 * ----------------------------------
 * 关闭客户端浏览器，服务器并不知道session挂了
 */

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome.view")
public class Welcome extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        out.println("" +
                "<!doctype html>\n" +
                "<html lang=\"zh\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>欢迎</title>\n" +
                "</head>\n" +
                "<body>" +
                "   <h1>目前在线人数: " + OnlineUserCounter.getCounter() + "人</h1>");

        if (session != null) {
            String user = (String) session.getAttribute("user");
            out.println("" +
                    "   <h1>欢迎: " + user + "</h1>" +
                    "   <a href='logout.do'>注销</a>");
        }
        out.println("" +
                "</body>" +
                "</html>");
        out.close();
    }
}