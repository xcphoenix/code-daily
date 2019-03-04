/*
* 简单的 Model 2 架构程序 - 控制器
**/

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello.do")
public class HelloController extends HttpServlet {
    private HelloModel model = new HelloModel();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("user");     // 收集请求参数
        String message = model.doHello(name);              // 委托HelloModel对象处理
        request.setAttribute("message", message);       // 将结果信息设置为请求范围属性
        request.getRequestDispatcher("hello.view").forward(request, response);      // 转发给 hello.view 进行响应
    }
}