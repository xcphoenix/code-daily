package xuanc.chapter7;

import java.io.File;
import java.util.Scanner;

/**
 * ClassName    Chapter7-ScannerFileTest
 * Description  从文件中读取
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-29 下午9:48
 */
public class ScannerFileTest {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("/tmp/hello.c"));
        System.out.println("文件内容如下：");
        int lineNumber = 0;

        while (sc.hasNextLine()) {
            System.out.println(++lineNumber + " " + sc.nextLine());
        }
    }

}
