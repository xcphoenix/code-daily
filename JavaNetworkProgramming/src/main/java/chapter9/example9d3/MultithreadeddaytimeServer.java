package chapter9.example9d3;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author      xuanc
 * @date        2019/12/9 下午10:31
 * @version     1.0
 */ 
public class MultithreadeddaytimeServer {

    public final static int PORT = 1313;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket connection = server.accept();
                    Thread task = new DaytimeThread(connection);
                    task.start();
                } catch (IOException ignoreEx) {}
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static class DaytimeThread extends Thread {
        private final Socket connection;

        DaytimeThread(Socket connection) {
            this.connection = connection;
            System.out.println("线程开始...");
        }

        @Override
        public void run() {
            try (connection) {
                Writer out = new OutputStreamWriter(connection.getOutputStream());
                Date now = new Date();
                out.write(now.toString() + "\r\n");
                out.flush();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

}

