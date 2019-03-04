/*
 *  编码处理
 */

import sun.nio.cs.ext.Big5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/encoding")
public class EncodingServlet extends HttpServlet {
    // Tomcat8URI默认编码为“UTF-8”，而Tomcat7URI默认编码为“ISO-8859-1(单字节编码)”
    // 原书环境: Tomcat7
    // 原书应该是繁体, 网页以繁体显示且使用Tomcat7, 运行正常

    /**
     * 原文: <a href="https://blog.csdn.net/h12kjgj/article/details/73496528">[转]Java 正确的做字符串编码转换</a>
     * ...
     * 那么，如何利用getBytes 和 new String() 来进行编码转换呢？  网上流传着一种错误的方法:
     * GBK--> UTF-8:    new String( s.getBytes("GBK") , "UTF-8);   ,这种方式是完全错误的，因为getBytes 的编码与  UTF-8 不一致，肯定是乱码。
     * 但是为什么在tomcat 下，使用 new String(s.getBytes("iso-8859-1") ,"GBK") 却可以用呢？ 答案是：
     * tomcat 默认使用iso-8859-1编码， 也就是说，如果原本字符串是GBK的，tomcat传输过程中，将GBK转成iso-8859-1了，
     * 默认情况下，使用iso-8859-1读取中文肯定是有问题的，那么我们需要将iso-8859-1 再转成GBK， 而iso-8859-1 是单字节编码的，
     * 即他认为一个字节是一个字符， 那么这种转换不会对原来的字节数组做任何改变，因为字节数组本来就是由单个字节组成的，
     * 如果之前用GBK编码，那么转成iso-8859-1后编码内容完全没变， 则 s.getBytes("iso-8859-1")  实际上还是原来GBK的编码内容
     * 则 new String(s.getBytes("iso-8859-1") ,"GBK")  就可以正确解码了。 所以说这是一种巧合。
     * ...
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nameGet");
//        System.out.println("GET-before: "+ name);
//        name = new String(name.getBytes("ISO-8859-1"), "GBK");
        name = new String(name.getBytes("ISO-8859-1"), "Big5");
        System.out.println("GET: "+ name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("Big5");
        String name = req.getParameter("namePost");
        System.out.println("POST:" + name);
    }

}