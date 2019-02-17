/*
* 简单的微博 - 登录界面
* */

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/login.do")
public class Login extends HttpServlet {
    private final String USERS = "/tmp/weibo/USER";
    private final String SUCCESS_VIEW = "member.view";
    private final String ERROR_VIEW = "register.html";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (checkLogin(username, password)) {
            request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
            // 符合转发到登录界面
        }
        else {
            response.sendRedirect(ERROR_VIEW);
            //　名称与密码不符合，回到首页
        }
    }

    private boolean checkLogin(String username, String password) throws IOException {
        if (username != null && password != null) {
            for (String file : new File(USERS).list()) {
                if (file.equals(username)) {
                    BufferedReader reader = new BufferedReader(new FileReader(USERS + "/" + file + "/profile"));
                    String passwd = reader.readLine().split("\t")[1];
                    System.out.println("passwd: " + passwd);
                    // public String[] split(@NotNull String regex)
                    // Splits this string around matches of the given regular expression.
                    // This method works as if by invoking the two-argument split method with the given expression
                    // and a limit argument of zero. Trailing empty strings are therefore not included in the resulting array.
                    if(passwd.equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}