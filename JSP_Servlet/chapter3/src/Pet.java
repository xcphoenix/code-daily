/*
* 宠物类型大调查
* */

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pet")
public class Pet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");                  // 设置请求对象字符编码
        response.setContentType("text/html; charset=UTF-8");    // 设置内容类型

        PrintWriter out = response.getWriter();                 // 取得输出对象
        out.println("<html>");
        out.println("<head>");
        out.println("<title>感谢填写</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("联系人: <a href='mailto:" + request.getParameter("email") + "'>" + request.getParameter("user") + "</a>");
        out.println("<br>喜爱的宠物类型");
        out.println("<ul>");
        for (String type : request.getParameterValues("type")) {
            out.println("<li>" + type + "</li>");
        }
        // String[] getParameterValues(String s)
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}