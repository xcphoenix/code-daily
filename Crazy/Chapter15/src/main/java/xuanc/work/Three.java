package xuanc.work;

import xuanc.FileInputStreamTest;
import xuanc.FileReaderTest;

import java.io.*;
import java.util.Arrays;

/**
 * ClassName    Chapter15-Three
 * Description  
 *
 * @author      xuanc
 * @date        19-5-6 上午12:20
 * @version     1.0
 */ 
public class Three {

    public static void main(String[] args) throws IOException {
        listFile(new File("src/main/java/xuanc/work"), "@date");
    }

    static void listFile(File root, String string) throws IOException {
        if (!root.isDirectory()) {
            return;
        }
        File[] nameList = root.listFiles();
        if (nameList != null) {
            for (File name : nameList) {
                if (isHaveString(name, string)) {
                    System.out.println(name.getAbsolutePath());
                }
            }
        }
    }

    static boolean isHaveString(File file, String string) throws IOException {
        System.out.println(">>> " + file.getAbsolutePath());

        if (file.isDirectory()) {
            return false;
        }

        int length = 0;
        String strInMem = "";
        // BufferedReader fi = new BufferedReader(new FileReader(file));
        FileReader fi = new FileReader(file);
        char[] buf = new char[1024];
        // String line = null;
        int line = 0;
        // while ((line = fi.readLine()) != null) {
        //     strInMem += line;
        // }
        while ((line = fi.read(buf)) != -1) {
            strInMem += (Arrays.copyOfRange(buf, 0, line - 1)).toString();
        }
        fi.close();
        System.out.println(strInMem);
        System.out.printf("-->" +
                "" +
                " %s\n", strInMem);
        return strInMem.contains(string);
    }
}
