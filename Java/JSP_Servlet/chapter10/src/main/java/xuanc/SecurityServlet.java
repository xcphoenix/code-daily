package xuanc;

import java.io.*;
import java.security.AccessControlException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * ClassName    chapter10-SecurityServlet
 * Description  TODO
 * @author      xuanc
 * @date        19-3-13 下午4:48
 * @version     1.0
 */
@WebServlet(
        name = "SecurityServlet",
        urlPatterns = {"/security"}
)
public class SecurityServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("其他用户可以看到的数据一");
        try {
            // 检查用户是否已通过容器验证，否则根据 web.xml 中的设置，要求身份验证，如果通过验证显示接下来的内容
            request.authenticate(response);
            out.println("必须验证过的用户才可以看到的资料");
        } catch (AccessControlException ex) {
            ex.printStackTrace();
        }
        out.println("其他用户就可以看到的数据二");
    }
}
