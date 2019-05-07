package xuanc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * ClassName    Chapter15-WriteToProcess
 * Description  
 *
 * @author      xuanc
 * @date        19-5-5 下午8:15
 * @version     1.0
 */ 
public class WriteToProcess {

    public static void main(String[] args) throws IOException {
        // File file = new File(".");
        // System.out.println(file.getAbsolutePath());
        // 运行 java ReadStandard 命令，返回运行该命令的字进程
        Process p = Runtime.getRuntime().exec("java -cp out/production/Chapter15/ xuanc.ReadStandard");
        try (PrintStream ps = new PrintStream(p.getOutputStream())) {
            ps.println("普通字符串");
            ps.println(new WriteToProcess());
        }
    }
}

class ReadStandard {
    public static void main(String[] args) {
        try (
                Scanner sc = new Scanner(System.in);
                PrintStream ps = new PrintStream(
                        new FileOutputStream("out.txt")
                );
        ){
            sc.useDelimiter("\n");
            while(sc.hasNext()) {
                ps.println("键盘输入的内容是：" + sc.next());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}