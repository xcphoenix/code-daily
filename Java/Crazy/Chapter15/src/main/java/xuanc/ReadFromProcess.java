
package xuanc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xuanc
 */
public class ReadFromProcess {

    public static void main(String[] args) throws IOException {
        // 运行 javac 命令，返回运行该命令的子进程
        Process p = Runtime.getRuntime().exec("javac");
        try (
                // 获取子进程的输入流
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(p.getInputStream()))
        ) {
            String buff = null;
            while((buff = br.readLine()) != null) {
                System.out.println(buff);
            }
        }
    }
}