/*
* 使用 getOutputStream() 输出二进制字符
* */

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 应该是　doPost()方法，为了简化流程．．
        String passwd = request.getParameter("passwd");
        if ("123456".equals(passwd)) {
            response.setContentType("application/pdf"); // 设置内容类型
            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/test.pdf");
            // 取得输入流
            OutputStream out = response.getOutputStream();
            // 取得输出流
            writeBytes(in, out);
            in.close();
            out.close();
        }
    }

    private void writeBytes(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = in.read(buffer)) != -1) {
            out.write(buffer, 0, length);
        }
    }
}