package xuanc.java.mail;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.Part;
// for 多重内容
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

/**
 * ClassName    chapter11-MailServlet2
 * Description  TODO
 *
 * @author xuanc
 * @date 19-3-14 下午9:38
 * @version 1.0
 */

/**
 * 为了支持上传文件
 */
@MultipartConfig
@WebServlet(
        urlPatterns = {"/mail2.do"},
        initParams = {
                @WebInitParam(name = "mailHost", value = "smtp.163.com"),
                @WebInitParam(name = "mailPort", value = "465"),
                @WebInitParam(name = "username", value = "********@163.com"),
                @WebInitParam(name = "password", value = "********")
        }
)
public class MailServlet2 extends HttpServlet {
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
        response.setContentType("text/html;UTF-8");

        // 获取参数
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String text = request.getParameter("text");
        Part part = request.getPart("file");

        try {
            Message message = getMessage(from, to, subject, text, part);
            // 传送邮件
            Transport.send(message);
            response.getWriter().println("邮件发送成功");
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    private Message getMessage(String from, String to, String subject, String text, Part part)
            throws MessagingException, AddressException, IOException {
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setSentDate(new Date());

        // 处理html内容类型----------------------------------------------
        // 代表 HTML 内容类型的对象
        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(text, "text/html;charset=UTF-8");
        // 创建可包含多重内容的邮件内容
        Multipart multipart = new MimeMultipart();
        // 新增 HTML 内容类型
        multipart.addBodyPart(htmlPart);

        // 如果有上传文件，处理文件内容
        String filename = getFilename(part);
        if (!"".equals(filename)) {
            MimeBodyPart filePart = new MimeBodyPart();
            // 编码
            filePart.setFileName(MimeUtility.encodeText(filename, "UTF-8", "B"));
            // 设定内容以及内容类型
            filePart.setContent(getBytes(part), part.getContentType());
            multipart.addBodyPart(filePart);
        }

        // 设定为邮件内容
        message.setContent(multipart);
        return message;
    }

    // 获取文件名
    private String getFilename(Part part) {
        String header = part.getHeader("Content-Disposition");
        String filename = header.substring(header.indexOf("filename=\"") + 10,
                header.lastIndexOf("\""));
        return filename;
    }

    private byte[] getBytes(Part part) throws IOException {
        InputStream in = part.getInputStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = in.read(buffer)) != -1) {
            out.write(buffer, 0, length);
        }
        in.close();
        out.close();
        return out.toByteArray();
    }
}
