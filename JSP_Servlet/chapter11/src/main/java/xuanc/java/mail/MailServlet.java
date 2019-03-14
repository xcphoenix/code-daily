package xuanc.java.mail;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * ClassName    chapter11-MailServlet
 * Description  TODO
 * @author      xuanc
 * @date        19-3-13 下午5:48
 * @version     1.0
 */
@WebServlet(
        urlPatterns = {"/mail.do"},
        initParams = {
                @WebInitParam(name = "mailHost", value = "smtp.163.com"),
                @WebInitParam(name = "mailPort", value = "465"),
                @WebInitParam(name = "username", value = "PhoenixBM@163.com"),
                @WebInitParam(name = "password", value = "shouquanma123")
        }
)
public class MailServlet extends HttpServlet{
    private String mailHost;
    private String mailPort;
    private String username;
    private String password;
    /**
     * Properties 继承于 Hashtable.表示一个持久的属性集.属性列表中每个键及其对应值都是一个字符串。
     * Properties 类被许多Java类使用。例如，在获取环境变量时它就作为System.getProperties()方法的返回值。
     * Properties 定义如下实例变量.这个变量持有一个Properties对象相关的默认属性列表。
     */
    private Properties props;

    @Override
    public void init() throws ServletException {
        mailHost = getServletConfig().getInitParameter("mailHost");
        mailPort = getServletConfig().getInitParameter("mailPort");
        username = getServletConfig().getInitParameter("username");
        password = getServletConfig().getInitParameter("password");

        // 设置会话必要属性
        props = new Properties();
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.host", "smtp.163.com");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.debug", "true");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String text = request.getParameter("text");

        try {
            Message message = getMessage(from, to, subject, text);
            // 传送邮件
            Transport.send(message);
            response.getWriter().println("邮件发送成功");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private Message getMessage(String from, String to, String subject, String text)
        throws MessagingException, AddressException {
        // 取得代表当次邮件传送会话的 Session 对象
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        // 创建邮件信息
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setSentDate(new Date());
        message.setText(text);
        return message;
    }

}
