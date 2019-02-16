/*
 * 微博：注册处理
 * */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

@WebServlet("/register.do")
public class Register extends HttpServlet {
    private final String USERS = "/tmp/weibo/USER";
    private final String SUCCESS_VIEW = "success.view";
    private final String ERROR_VIEW = "error.view";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmedPassword = request.getParameter("confirmedPasswd");

        // 验证参数
        List<String> errors = new ArrayList<String>();
        if (isInvalidEmail(email)) {
            errors.add("未填写邮件或邮件样式不正确");
        }
        if (isInvalidUsername(username)) {
            errors.add("用户名为空或已存在");
        }
        if (isInvalidPassword(password, confirmedPassword)) {
            errors.add("请确认密码符合格式并再次确认密码");
        }

        String resultPage = ERROR_VIEW;
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            // 如果窗体验证出现错误，设置收集错误的 List 为请求属性
        } else {
            resultPage = SUCCESS_VIEW;
            createUserData(email, username, password);
            System.out.println("创建资料．．~");
            // 创建用户资料
        }
        System.out.println(resultPage);
        request.getRequestDispatcher(resultPage).forward(request, response);
        // 转到显示结果的 Servlet
    }

    private boolean isInvalidEmail(String email) {
        return email == null || !email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");
        // ^: 匹配输入字符串的开始位置，除非在方括号表达式中使用，此时它表示不接受该字符集合。要匹配 ^ 字符本身，请使用 \^。
        // $: 结束位置
        // (): 标记一个子表达式的开始和结束位置。子表达式可以获取供以后使用
        // *:  匹配前面的子表达式零次或多次。要匹配 * 字符，请使用 \*。
        // +:  匹配前面的子表达式一次或多次。要匹配 + 字符，请使用 \+。
        // [a-z]: 字符范围。匹配指定范围内的任意字符。例如，“[a-z]"可以匹配"a"到"z"范围内的任意小写字母字符。
    }

    private boolean isInvalidUsername(String username) {
        for (String file : new File(USERS).list()) {
            // String[] list()
            // 返回目录中的文件或目录
            if (file.equals(username)) {
                return true;
            }
            // 检查用户资料是否创建
        }
        return false;
    }

    private boolean isInvalidPassword(String password, String confirmedPasswd) {
        return password == null ||
                password.length() < 6 ||
                password.length() > 16 ||
                !password.equals(confirmedPasswd);
    }

    /*
     * 创建用户资料
     * */
    private void createUserData(String email, String username, String password) throws IOException {
        File userhome = new File(USERS + "/" + username);
        // File(String pathname)
        // 通过将给定路径名字符串转换成抽象路径名来创建一个新 File 实例。
        userhome.mkdir();
        // public boolean mkdirs()
        // 创建此抽象路径名指定的目录，包括创建必需但不存在的父目录。
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(userhome.getPath() + "/profile"));
/*        BufferedWriter writer = new BufferedWriter(
                new FileWriter(userhome + "/profile"));*/


        // >> File Object + String Object -> String ?
        // java.io.IOException – if the named file exists but is a
        // directory rather than a regular file, does not exist but
        // cannot be created, or cannot be opened for any other reason
        writer.write(email + "\t" + password);
        writer.close();
    }
}