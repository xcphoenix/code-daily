package chapter9.example9d1;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author      xuanc
 * @date        2019/12/9 下午10:08
 * @version     1.0
 */ 
public class DaytimeServer {

    public final static int PORT = 1313;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)){
            while (true) {
                try (Socket connection = server.accept()){
                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    Date now = new Date();
                    out.write(now.toString() + "\r\n");
                    out.flush();
                } catch (IOException ignored) {}
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
