package chapter9.example9d11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;

/**
 * @author      xuanc
 * @date        2019/12/10 下午6:14
 * @version     1.0
 */ 
public class Redirector {

    private static final Logger logger = LoggerFactory.getLogger(Redirector.class);

    private final int port;
    private final String newSite;

    public Redirector(String newSite, int port) {
        this.port = port;
        this.newSite = newSite;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(port)) {
            logger.info("Redirecting connections on port " + server.getLocalPort());

            while (true) {
                try {
                    Socket s = server.accept();
                    Thread t = new RedirectThread(s);
                    t.start();
                } catch (IOException ex) {
                    logger.warn("Exception accepting connection");
                } catch (RuntimeException ex) {
                    logger.error("Unexpected error", ex);
                }
            }

        } catch (BindException ex) {
            logger.error("Could not start server", ex);
        } catch (IOException ex) {
            logger.error("Error opening server socket", ex);
        }
    }

    private class RedirectThread extends Thread {

        private final Socket connection;

        public RedirectThread(Socket connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            try {
                Writer out = new BufferedWriter(
                        new OutputStreamWriter(
                                connection.getOutputStream(), StandardCharsets.US_ASCII
                        )
                );
                Reader in = new InputStreamReader(
                        new BufferedInputStream(
                                connection.getInputStream()
                        )
                );

                StringBuilder request = new StringBuilder(80);
                while (true) {
                    int c = in.read();
                    if (c == '\r' || c == '\n' || c == -1) {
                        break;
                    }
                    request.append((char)c);
                }

                String get = request.toString();
                // has bug
                String[] pieces = get.split("^(/|http(s)?://|.)[\\w.]*");
                String theFile = pieces[1];

                logger.debug(Arrays.toString(pieces));

                if (get.contains("HTTP")) {
                    out.write("HTTP/1.0 302 FOUND\r\n");
                    Date now = new Date();
                    out.write("Date: " + now + "\r\n");
                    out.write("Location: " + newSite + theFile + "\r\n");
                    out.write("Content-type: text/html\r\n\r\n");
                    out.flush();
                }

                out.write("<HTML><HEAD><TITLE>Document moved</TITLE></HEAD>\r\n");
                out.write("<BODY><H1>Document moved</H1>\r\n");
                out.write("The document " + theFile + " has moved to\r\n<A HREF=\"" + newSite + theFile + "\">" +
                        newSite + theFile +
                        "</A>.\r\n Please update your bookmarks<P>");
                out.write("</BODY></HTML>\r\n");
                out.flush();
                logger.info("Redirected " + connection.getRemoteSocketAddress());

            } catch (IOException ex) {
                logger.warn("Error talking to " + connection.getRemoteSocketAddress(), ex);
            } finally {
                try {
                    connection.close();
                } catch (IOException ignored) {}
            }
        }
    }

    public static void main(String[] args) {

        int thePort;
        String theSite = null;
        try {
            theSite = args[0];
            if (theSite.endsWith("/")) {
                theSite = theSite.substring(0, theSite.length() - 1);
            }
        } catch (RuntimeException ex) {
            System.out.println("Usage: java Redirector http://www.newsite.com/ port");
            return;
        }

        try {
            thePort = Integer.parseInt(args[1]);
        } catch (RuntimeException ex) {
            thePort = 1880;
        }

        Redirector redirector = new Redirector(theSite, thePort);
        redirector.start();
    }

}
