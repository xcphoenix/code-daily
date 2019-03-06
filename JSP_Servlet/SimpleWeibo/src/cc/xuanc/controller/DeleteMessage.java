package cc.xuanc.controller;

import cc.xuanc.model.Blah;
import cc.xuanc.model.UserService;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName    SimpleWeibo-DeleteMessage
 * Description  处理删除消息的行为　
 * @author      xuanc
 * @date        19-3-5 下午6:52
 * @version     1.0
 */
@WebServlet({"/deleteMessage.do"})
public class DeleteMessage extends HttpServlet {
    String dealMessage = "message.do";

    public DeleteMessage() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Blah blah = new Blah();
        blah.setUsername((String)request.getSession().getAttribute("login"));
        blah.setDate(new Date(Long.parseLong(request.getParameter("date"))));
        UserService userService = (UserService)this.getServletContext().getAttribute("userService");
        // 删除微博
        userService.deleteMessage(blah);
        // 重定向
        response.sendRedirect(dealMessage);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }
}
