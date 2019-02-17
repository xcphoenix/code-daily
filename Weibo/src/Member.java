/*
* 简单的微博 - 会员界面
* */


import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/member.view")
public class Member extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>\n" +
                "<html lang=\"zh\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"\n" +
                "          name=\"viewport\">\n" +
                "    <meta content=\"ie=edge\" http-equiv=\"X-UA-Compatible\">\n" +
                "    <title>用户中心</title>\n" +
                "</head>" +
                "<body>" +
                "<h1>会员" + request.getParameter("username") + " 你好</h1>" +
                "</body>" +
                "</html>");
        out.close();
    }
}