package chapter9.example9d6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author      xuanc
 * @date        2019/12/9 下午11:00
 * @version     1.0
 */ 
public class LoggingDaytimeServer {

    private final static int PORT = 1313;
    private final static Logger logger = LoggerFactory.getLogger(LoggingDaytimeServer.class);
    private final static Logger errLogger = LoggerFactory.getLogger(LoggingDaytimeServer.class + "-error");

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(50);

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket connection = server.accept();
                    Callable<Void> task = new DaytimeTask(connection);
                    pool.submit(task);
                } catch (IOException ex) {
                    errLogger.error("accept error " + ex.getMessage(), ex);
                } catch (RuntimeException ex) {
                    errLogger.error("unexpected error " + ex.getMessage(), ex);
                }
            }
        } catch (IOException ex) {

        }

    }

    private static class DaytimeTask implements Callable<Void> {

        private final Socket connection;

        DaytimeTask(Socket connection) {
            this.connection = connection;
        }

        @Override
        public Void call() {
            try (connection) {
                Writer out = new OutputStreamWriter(connection.getOutputStream());
                Date now = new Date();
                out.write(now.toString() + "\r\n");
                out.flush();
            } catch (IOException ex) {
                System.err.println(ex);
            }
            return null;
        }
    }
}
