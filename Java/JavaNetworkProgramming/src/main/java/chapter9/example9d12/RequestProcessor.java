package chapter9.example9d12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author      xuanc
 * @date        2019/12/10 下午10:10
 * @version     1.0
 */ 
public class RequestProcessor implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(chapter9.example9d12.RequestProcessor.class);

    private File rootDirectory;
    private String indexFileName = "index.html";
    private Socket connection;

    public RequestProcessor(File rootDirectory, String indexFileName, Socket connection) {

        if (rootDirectory.isFile()) {
            throw new IllegalArgumentException("rootDirectory must be a directory, not a file");
        }

        try {
            // 解析为规范路径
            rootDirectory = rootDirectory.getCanonicalFile();
        } catch (IOException ignored) {}

        this.rootDirectory = rootDirectory;
        if (indexFileName != null) {
            this.indexFileName = indexFileName;
        }
        this.connection = connection;
    }

    @Override
    public void run() {
        // 安全检查
        String root = rootDirectory.getPath();
    }

}
