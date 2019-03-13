package cc.xuanc.controller;

import cc.xuanc.model.Blah;
import cc.xuanc.model.UserService;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName    SimpleWeibo-User
 * Description  处理用户中心
 * @author      xuanc
 * @date        19-3-7 下午6:38
 * @version     1.0
 */
@WebServlet(
        urlPatterns = {"/user/*"},
        initParams = {
                @WebInitParam(name = "USER_VIEW", value = "/user.jsp")
        }
)
public class User extends HttpServlet{
    private String USER_VIEW;

    @Override
    public void init() throws ServletException {
        USER_VIEW = getServletConfig().getInitParameter("USER_VIEW");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        String username = request.getPathInfo().substring(1);
        // 取得用户名称

        if (userService.isExisted(username)) {
            List<Blah> blahs = userService.getBlahs(username);
            request.setAttribute("blahs", blahs);
        }

        request.setAttribute("username", username);
        request.getRequestDispatcher(USER_VIEW).forward(request, response);
    }
}
