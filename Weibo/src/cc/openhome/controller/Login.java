/*
 * Weibo::Control - 登录
 */

package cc.openhome.controller;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/login.do")
public class Login extends HttpServlet {
    private final String USERS = "/WEB_INF/USERS";
    private final String SUCCESS_VIEW = "member.view";
    private final String ERROR_VIEW = "register.html";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String page = ERROR_VIEW;

        if (checkLogin(username, password)) {
            request.getSession().setAttribute("login", username);
            // 设定属性
            page = SUCCESS_VIEW;
        }
        response.sendRedirect(page);
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