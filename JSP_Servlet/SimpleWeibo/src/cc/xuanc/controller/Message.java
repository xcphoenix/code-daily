package cc.xuanc.controller;

import cc.xuanc.model.Blah;
import cc.xuanc.model.UserService;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName    SimpleWeibo-message
 * Description  处理添加消息
 * @author      xuanc
 * @date        19-3-5 下午6:52
 * @version     1.0
 */
@WebServlet("/message.do")
public class Message extends HttpServlet {
    private final String SUCCESS_VIEW = "member.jsp";
    private final String ERROR_VIEW = "member.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int contextLimit = 234;
        request.setCharacterEncoding("UTF-8");
        // 获取信息
        String message = request.getParameter("message");
        System.out.println("msg: " + message);
        UserService userService = (UserService) getServletContext().getAttribute("userService");

        // 获取微博
        List<Blah> blahs = userService.getBlahs((String)request.getSession().getAttribute("login"));
        request.setAttribute("blahs", blahs);

        if (message != null && message.length() != 0) {
            // 如果满足要求，添加消息
            if (message.length() <= contextLimit) {
                System.out.println(message);
                Blah msg = new Blah();
                msg.setUsername((String)request.getSession().getAttribute("login"));
                msg.setMessage(message);

                userService.addMessage(msg);
                blahs = userService.getBlahs((String)request.getSession().getAttribute("login"));
                request.setAttribute("blahs", blahs);

                request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
                // response.sendRedirect（）使用注意事项
                // 1. 重定向之后的代码会继续执行 （重定向代码之后加上return,可让之后的代码不再执行）
                // 2. 当前程序所有代码执行完毕后,才会执行重定向跳转
                // forward()后面的代码也会执行
            } else {
                request.setAttribute("error", "微博字数超出限制（234）");
                request.setAttribute("msg", message);
                request.getRequestDispatcher("member.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("msg", "");
            request.getRequestDispatcher(ERROR_VIEW).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
