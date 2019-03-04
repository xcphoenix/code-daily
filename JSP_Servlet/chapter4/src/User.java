/*
 * CookieDemo
 * HttpSessionDemo..
 */

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/user.view")
public class User extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("login") == null) {
            response.sendRedirect("login.html");
        }
        else {
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
                    "    <title>欢迎" + session.getAttribute("login") + "</title>\n" +
                    "</head>\n" +
                    "<body>" +
                    "   <h1>用户 " + session.getAttribute("login") + " 已登录</h1><br><br>" +
                    "   <a href='logout.view'>注销</a>" +
                    "</body>" +
                    "</html>");
            out.close();
        }

        // response.setContentType("text/html; charset=UTF-8");
        // // 如果没有登录，返回登录界面
        // if (request.getAttribute("user") == null) {
        //     response.sendRedirect("login.html");
        // }
        // PrintWriter out = response.getWriter();
        // out.println("<!doctype html>\n" +
        //         "<html lang=\"zh\">\n" +
        //         "<head>\n" +
        //         "    <meta charset=\"UTF-8\">\n" +
        //         "    <meta name=\"viewport\"\n" +
        //         "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
        //         "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
        //         "    <title>Servlet User</title>\n" +
        //         "</head>\n" +
        //         "<body>" +
        //         "<h1>" + request.getAttribute("user") + "已登录</h1>" +
        //         "</body>" +
        //         "</html>");
        // out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}