/*
 * 上传文件
 */

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
@WebServlet("/upload2.do")
public class UploadServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        // 处理中文文件名
        Part part = req.getPart("photo");
        // 使用 getPart() 取得 Part 对象
        String filename = getFilename(part);
        part.write(filename);
        // 直接调用 write() 方法写入文件到本地
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