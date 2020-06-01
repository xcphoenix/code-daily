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
 * ClassName    SimpleWeibo-Register
 * Description  处理用户注册行为
 * @author      xuanc
 * @date        19-3-4 下午6:11
 * @version     1.0
 */
@WebServlet("/register.do")
public class Register extends HttpServlet{
    private final String SUCCESS_VIEW = "success.jsp";
    private final String ERROR_VIEW = "register.jsp";

    /**
     * description  处理Post请求，如果注册成功重定向到 success.jsp，失败则重定向到注册页面，并返回错误信息
     * @author      xuanc
     * @date        下午6:16 19-3-4
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 取得请求参数
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        // 收集错误信息
        List<String> errors = new ArrayList<String>();
        // 重定向页面
        String resultPage = ERROR_VIEW;

        UserService userService = (UserService) getServletContext().getAttribute("userService");

        // 测试注册信息是否正确
        if (isInvalidUsername(username)) {
            errors.add("用户名为空或不符合格式");
        } else if (userService.isExisted(username)) {
            errors.add("用户名已存在");
        }

        if (isInvalidEmail(email)) {
            errors.add("邮箱未填写或格式错误");
        }

        if (isInvalidPassword(password, confirmPassword)) {
            errors.add("请确认密码一致且符合格式");
        }

        // 重定向网页
        if (errors.isEmpty()) {
            // 创建用户资料
            userService.createUser(username, password, email);
            resultPage = SUCCESS_VIEW;
        } else {
            // 设置请求范围属性，重定向后显示错误信息
            request.setAttribute("errors", errors);
            request.getRequestDispatcher(ERROR_VIEW).forward(request, response);
        }

        response.sendRedirect(resultPage);
    }

    /**
     * 测试用户名是否有效
     */
    private boolean isInvalidUsername(String username) {
        return username == null || !username.matches("^[0-9a-zA-Z]+");
    }

    /**
     * 正则表达式测试邮箱格式是否正确
     */
    private boolean isInvalidEmail(String email) {
        return email == null || !email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");
    }

    /**
     * 测试密码是否符合格式要求
     */
    private boolean isInvalidPassword(String password, String confirmedPassword) {
        return password == null || password.length() < 6
                || password.length() > 16 || !password.equals(confirmedPassword);
    }
}
