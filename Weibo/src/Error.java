/*
* 错误显示
* */

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/error.view")
public class Error extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>\n" +
                "<html lang=\"zh-CN\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"\n" +
                "          name=\"viewport\">\n" +
                "    <meta content=\"ie=edge\" http-equiv=\"X-UA-Compatible\">\n" +
                "    <title>新增会员失败</title>\n" +
                "</head>" +
                "<h1>新增会员失败</h1>" +
                "<body>");

        out.println("<ul style='color: RED'>");
        List<String> errors = (List<String>) request.getAttribute("errors");
        for (String error : errors) {
            out.println("<li>" + error + "</li>");
        }
        out.println("<ul>");
        out.println("<a href='register.html>返回注册页面</a>");
        out.println("</body>\n" +
                "</html>");
        out.close();
    }
}