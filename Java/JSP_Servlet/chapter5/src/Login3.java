/*
 * SessionListenDemo2 Login3.java
 */

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/login3.do")
public class Login3 extends HttpServlet {
    private Map<String, String> users = new HashMap<>();

    public Login3() {
        users.put("caterpillar", "123456");
        users.put("momor", "123456");
        users.put("haimi", "123456");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");

        String page = "form.html";
        if (users.containsKey(name) && users.get(name).equals(passwd)) {
            User user = new User(name);
            request.getSession().setAttribute("user", user);
            page = "welcome.view";
        }
        response.sendRedirect(page);
    }
}
