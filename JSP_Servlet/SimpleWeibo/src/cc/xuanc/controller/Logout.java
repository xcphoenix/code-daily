package cc.xuanc.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName    SimpleWeibo-Logout
 * Description  处理注销行为
 * @author      xuanc
 * @date        19-3-5 下午6:52
 * @version     1.0
 */
@WebServlet("/logout.do")
public class Logout extends HttpServlet {
    private String loginView = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // 销毁 Session
        request.getSession().invalidate();
        // 重定向至登录页面
        response.sendRedirect(loginView);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
