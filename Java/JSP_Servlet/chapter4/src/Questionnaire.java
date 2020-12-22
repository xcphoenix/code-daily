/*
* 隐藏域示例 - 问卷调查
* ------------------
* HttpSessionDemo - Questionnaire.java
* */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/questionnaire")
public class Questionnaire extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>\n" +
                "<html lang=\"zh\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"\n" +
                "          name=\"viewport\">\n" +
                "    <meta content=\"ie=edge\" http-equiv=\"X-UA-Compatible\">\n" +
                "    <title>问卷调查</title>\n" +
                "</head>\n" +
                "<body>");

        String page = request.getParameter("page");
        // @Para page : 决定显示哪一页问卷
        out.println("<form action='questionnaire' method='post'>");
        if (page == null) {
            out.println("问题一： <input type='text' name='p1q1'><br>");
            out.println("问题二： <input type='text' name='p1q2'><br>");
            out.println("<input type='submit' name='page' value='下一页'>");
        } else if ("下一页".equals(page)) {
            String p1q1 = request.getParameter("p1q1");
            String p1q2 = request.getParameter("p1q2");
            out.println("问题三：<input type='text' name='p2q1'><br>");
            out.println("<input type='submit' name='page' value='完成'>");

            // ############################# 隐藏域 ##################################
            // 第一页问卷答案，使用隐藏域发送答案
            // out.println("<input type='hidden' name='p1q1' value='" + p1q1 + "'>");
            // out.println("<input type='hidden' name='p1q2' value='" + p1q2 + "'>");

            HttpSession session = request.getSession();
            // 创建对象
            session.setAttribute("p1q1", p1q1);
            session.setAttribute("p1q2", p1q2);
            // 设置属性，存储第一页答案
        } else if ("完成".equals(page)) {
            // ############################# 隐藏域 ##################################
            // out.println(request.getParameter("p1q1") + "<br>");
            // out.println(request.getParameter("p1q2") + "<br>");
            // out.println(request.getParameter("p2q1") + "<br>");

            HttpSession session = request.getSession();

            out.println(session.getAttribute("p1q1") + "<br>");
            out.println(session.getAttribute("p1q2") + "<br>");
            out.println(request.getParameter("p2q1") + "<br>");
        }
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
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