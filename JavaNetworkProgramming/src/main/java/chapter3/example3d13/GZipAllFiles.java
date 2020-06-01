package chapter3.example3d13;

import java.io.File;
import java.util.concurrent.*;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import javax.annotation.security.RunAs;

/**
 * @author      xuanc
 * @date        2019/12/7 下午8:41
 * @version     1.0
 */ 
public class GZipAllFiles {

    private final static int THREAD_COUNT = 4;
    private final static int MAX_THREAD_COUNT = 200;
    private final static int BLOCKED_THREAD_COUNT = 1024;

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("example-pool-%d")
                .build();

        /*
         * 手动创建线程池
         */
        ExecutorService pool = new ThreadPoolExecutor(THREAD_COUNT, MAX_THREAD_COUNT, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(BLOCKED_THREAD_COUNT),
                namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        String[] mockArgs = new String[] {"/tmp/yaourt-tmp-xuanc"};

        for (String filename : mockArgs) {
            File f = new File(filename);
            if (f.exists()) {
                if (f.isDirectory()) {
                    File[] files = f.listFiles();
                    for (int i = 0; files != null && i < files.length; i++) {
                        if (!files[i].isDirectory()) {
                            Runnable task = new GZipRunable(files[i]);
                            pool.submit(task);
                        }
                    }
                } else {
                    Runnable task = new GZipRunable(f);
                    pool.submit(task);
                }
            }
        }

        pool.shutdown();
    }

}
