import java.io.IOException;
import java.io.PrintWriter;
// Writer的字符处理装饰器类，与 PrintStream 使用上类似，
// 可以对 OutputStream 和 Writer 打包，提供 print(), println(), format()等方法

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

// 如果请求的 URL 是 /hello.view，会由 HelloServlet 来后处理请求
@WebServlet("/hello.view")
// 继承 HttpServlet 类
public class HelloServlet extends HttpServlet{
    // 重新定义 doGet() 方法
    // 当浏览器GET方法发送请求时，会调用此方法
    // 容器接受到请求后，收集HTTP请求中的信息，分别创建代表请求和响应的Java对象

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型，告知浏览器返回的内容要以text/html解析，并采用UTF-8编码方式
        response.setContentType("text/html;charset=UTF-8");
        // 取得响应输出对象
        PrintWriter out = response.getWriter();
        // 取得请求参数
        String name = request.getParameter("name");

        // 输出对浏览器输出响应的信息
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello!" + name + " !</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}
