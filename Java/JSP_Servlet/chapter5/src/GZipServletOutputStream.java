/*
 * FilterDemo GZipServletOutputStream.java
 */

import java.io.*;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletOutputStream;

// 继承 ServletOutputStream 进行扩展
public class GZipServletOutputStream extends ServletOutputStream {
    private GZIPOutputStream gzipOutputStream;

    public GZipServletOutputStream(ServletOutputStream servletOutputStream) throws IOException {
        this.gzipOutputStream = new GZIPOutputStream(servletOutputStream);
    }

    public void write(int b) throws IOException {
        gzipOutputStream.write(b);
    }

    public GZIPOutputStream getGzipOutputStream() {
        return gzipOutputStream;
    }
}