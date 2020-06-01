package xuanc.work;

import java.io.File;

/**
 * ClassName    Chapter15-Two
 * Description  
 *
 * @author      xuanc
 * @date        19-5-6 上午12:03
 * @version     1.0
 */ 
public class Two {

    public static void main(String[] args) {
        listFile(new File("/gxy/temp"), "gxy0");
    }

    static void listFile(File root, String fileName) {
        // System.out.println("******" + root.getAbsolutePath() + "******");
        if (!root.isDirectory()) {
            return;
        }
        File[] nameList = root.listFiles();
        if (nameList != null) {
            for (File name : nameList) {
                if (name.getName().equals(fileName)) {
                    System.out.println(name.getAbsolutePath());
                }

                listFile(name, fileName);
            }
        }

    }

}
