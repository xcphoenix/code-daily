/*
*  取得并显示浏览器标头信息
*/

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header.view")
public class HeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>HeaderServlet</title>");
        out.println("</head>");
        out.println("<body>");

        // 取得应用程序环境路径
        out.println("<h1>HeaderServlet at " + req.getContextPath() + "</h1>");
        Enumeration<String> names = req.getHeaderNames();

        while (names.hasMoreElements()) {
            String name = names.nextElement();
            out.println(name + ": " + req.getHeader(name) + "<br>");
        }

        String namem = new String();

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}