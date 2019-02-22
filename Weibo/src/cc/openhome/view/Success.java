/*
 * Weibo::View - 注册成功提示
 */

package cc.openhome.view;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/success.view")
public class Success extends HttpServlet {
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
                "    <title>注册成功</title>\n" +
                "</head>" +
                "<body>" +
                "<h1>注册成功！</h1>" +
                "Hi~, " + request.getParameter("username") +
                "<br><a href='index.jsp'>回到首页</a>" +
                "</body>" +
                "</html>");
    }
}

