/*
* UrlRwDemo
**/

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                "    <title>搜索结果</title>\n" +
                "</head>\n" +
                "<body>");

        String start = request.getParameter("start");
        if (start == null) {
            start = "1";
        }

        int count = Integer.parseInt(start);
        int begin = 10 * count - 9;
        int end = 10 * count;
        out.println("第 " + begin + " 到 " + end + " 搜索结果<br>");
        out.println("<ul>");
        for (int i = 1; i <= 10; i++) {
            out.println("<li>搜寻结果" + i + "</li>");
        }
        out.println("</ul>");
        for (int i = 1; i < 10; i++) {
            if (i == count) {
                out.println(i);
                continue;
            }
            out.println("<a href='search?start=" + i + "'>" + i + "</a>");
        }
        out.println("" +
                "</body>" +
                "</html>");
        out.close();
    }
}