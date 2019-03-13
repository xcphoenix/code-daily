package xuanc;

import java.io.*;
import java.security.AccessControlException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * ClassName    chapter10-SecurityServlet2
 * Description  TODO
 * @author      xuanc
 * @date        19-3-13 下午4:59
 * @version     1.0
 */
@WebServlet(
        name = "SecurityServlet2",
        urlPatterns = {"/security2"}
)
public class SecurityServlet2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("其他用户就可以看到的数据一");
        try {
            String user = request.getParameter("user");
            String password = request.getParameter("passwd");
            // 在调用时可以提供用户名称、密码，利用容器设置的身份信息来验证
            request.login(user, password);
            out.println("必须通过验证的用户才可以看到的资料");
        } catch (AccessControlException ex) {
            ex.printStackTrace();
        } finally {
            request.logout();
        }
        out.println("其他用户就可以看到数据二");
    }
}
