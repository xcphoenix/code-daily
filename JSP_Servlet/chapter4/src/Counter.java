/**
 * HttpSession & URL 重写
 */

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/counter")
public class Counter extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int count = 0;
        HttpSession session = req.getSession();
        if (session.getAttribute("count") != null) {
            Integer c = (Integer) session.getAttribute("count");
            count = c + 1;
        }
        session.setAttribute("count", count);
        out.println("" +
                "<!doctype html>\n" +
                "<html lang=\"zh\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Servlet Count</title>\n" +
                "</head>\n" +
                "<body>" +
                "<h1>Servlet Count " + count + "</h1>" +
                "<a href='" + resp.encodeURL("counter") + "'>递增</a>" +
                "</body>" +
                "</html>");
        out.close();
    }
}