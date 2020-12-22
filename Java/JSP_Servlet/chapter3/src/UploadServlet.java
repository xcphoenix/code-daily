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

@MultipartConfig
// Tomcat 中必须使用此标注才能使用 getPart() 相关的API
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("Begin...");
        Part part = req.getPart("photo");
        // 使用 getPart() 取得 Part 对象
        String filename = getFilename(part);
        System.out.println("文件名: " + filename);
        writeTo(filename, part);
        // 用Java IO 写出到文件
    }

    private String getFilename(Part part) {
        String header = part.getHeader("Content-Disposition");
        if (header == null) {
            System.out.println("获取信息出错");
        }
        System.out.println("header: " + header);
        // 取得标头Content-Disposition的值
        String filename = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
        // 从值中取出文件名
        return filename;
    }

    private void writeTo(String filename, Part part) throws IOException {
       InputStream in = part.getInputStream();
       OutputStream out = new FileOutputStream("/home/xuanc/桌面/" + filename);
       byte[] buffer = new byte[1024];
       int length = -1;
       while ((length = in.read(buffer)) != -1) {
           out.write(buffer, 0, length);
       }
       in.close();
       out.close();
    }
}