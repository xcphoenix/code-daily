/*
 * ConfigDemo - Login.java
 */

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebInitParam;

@WebServlet(
        name = "login",
        urlPatterns = "/login.do",
        // 设置初始参数
        initParams = {
                @WebInitParam(name = "SUCCESS", value = "success.view", description = "描述1"),
                @WebInitParam(name = "ERROR", value = "error.view", description = "描述2")
        }
)
public class Login extends HttpServlet {
    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    // 重新定义无参数的 init() 方法，取得初始参数
    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getInitParameter("SUCCESS");
        ERROR_VIEW = getInitParameter("ERROR");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        if ("caterpillar".equals(name) && "123456".equals(passwd)) {
            request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
        }
        else {
            request.getRequestDispatcher(ERROR_VIEW).forward(request, response);
        }
    }
}