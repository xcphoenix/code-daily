package chapter3.example3d13;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * @author xuanc
 * @version 1.0
 * @date 2019/12/7 下午8:21
 */
public class GZipRunable implements Runnable {

    private final File input;

    public GZipRunable(File input) {
        this.input = input;
        System.out.println("Thread [" + Thread.currentThread().getName() + "] is created");
    }

    @Override
    public void run() {
        if (!input.getName().endsWith(".gz")) {
            File output = new File(input.getParent(), input.getName() + ".gz");
            if (!output.exists()) {
                try (
                        InputStream in = new BufferedInputStream(new FileInputStream(input));
                        OutputStream out = new BufferedOutputStream(
                                new GZIPOutputStream(new FileOutputStream(output))
                        )
                ) {
                    int b;
                    while ((b = in.read()) != -1) {
                        out.write(b);
                    }
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
