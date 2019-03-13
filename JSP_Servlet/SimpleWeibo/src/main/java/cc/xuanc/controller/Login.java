package cc.xuanc.controller;

import cc.xuanc.model.UserService;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName    SimpleWeibo-Login
 * Description  处理登录行为
 * @author      xuanc
 * @date        19-3-4 下午6:03
 * @version     1.0
 */
@WebServlet("/login.do")
public class Login extends HttpServlet{
    private final String SUCCESS_VIEW = "message.do";
    private final String ERROR_VIEW = "index.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = (UserService)getServletContext().getAttribute("userService");

        // 成功转发至会员页面
        if (userService.checkLogin(username, password)) {
            // 设置 session，无须重复登录
            request.getSession().setAttribute("login", username);
            response.sendRedirect(SUCCESS_VIEW);
        } else {
            request.setAttribute("error", "登录失败");
            request.getRequestDispatcher(ERROR_VIEW).forward(request, response);
        }
    }

}
