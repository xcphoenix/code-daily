/*
 * 上传文件
 */

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(location = "/tmp")
// Tomcat 中必须使用此标注才能使用 getPart() 相关的API
@WebServlet("/upload3.do")
public class UploadServlet3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        for (Part part : req.getParts()) {
            if(part.getName().startsWith("file")) {
                // 使用getName()获取名称, startsWith()判断名称是否以file开头
                String filename= getFilename(part);
                part.write(filename);
            }
        }
    }

    private String getFilename(Part part) {
        String header = part.getHeader("Content-Disposition");
        System.out.println("header: " + header);
        // 取得标头Content-Disposition的值
        String filename = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
        // 从值中取出文件名
        return filename;
    }
}