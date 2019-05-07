package xuanc.work;

import java.io.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * ClassName    Chapter15-One
 * Description  使用合并流实现图片的隐藏和还原
 *
 * @author      xuanc
 * @date        19-5-5 下午9:57
 * @version     1.0
 */ 
public class One {

    public static void main(String[] args) {
        try {
            cutFile(new File("/home/xuanc/图片/gxy.jpg"), 3, "gxy",
                    new File("/tmp"));
            Vector<FileInputStream> fileLists = new Vector<FileInputStream>();
            for (int i = 0; i < 3; i++) {
                fileLists.add(new FileInputStream(new File("/tmp", "default" + i)));
            }
            mergeFile(fileLists, new File("/tmp/recover.jpg"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void cutFile(File sourceFile, int number, String excludeName, File targetDir) throws Exception {
        if (number <= 0) {
            throw new Exception("number必须为正整数");
        }
        if (excludeName == null || excludeName.length() == 0) {
            excludeName = "default";
        }
        if (targetDir == null) {
            targetDir = sourceFile.getAbsoluteFile().getParentFile();
        }
        if (!sourceFile.exists() || !targetDir.exists() || !targetDir.isDirectory() || sourceFile.isDirectory()) {
            throw new Exception("文件或目录不存在");
        }

        long fileLength = sourceFile.length() / number;
        byte[] buf = new byte[1024];
        FileInputStream fis = new FileInputStream(sourceFile);

        for (int i = 0; i < number; i++) {
            if (i == number - 1) {
                fileLength = fileLength * (number - 1);
            }
            long needLength = fileLength;
            int readLength = 0;
            FileOutputStream fos = new FileOutputStream(new File(targetDir, excludeName + i));
            while ((readLength = fis.read(buf, 0, (int)Long.min(1024, needLength))) != -1) {
                needLength -= readLength;
                fos.write(buf, 0, readLength);
                if (needLength <= 0) {
                    fileLength += readLength;
                    break;
                }
            }
            fos.close();
        }
        fis.close();
    }

    static void mergeFile(Vector<FileInputStream> fileLists, File targetFile) throws Exception {
        if (targetFile == null) {
            throw new Exception("targetFile error..");
        }
        if (targetFile.exists()) {
            targetFile.renameTo(new File(targetFile.getName() + "_1"));
        }

        int length = 0;
        Enumeration enumeration = fileLists.elements();
        SequenceInputStream inputStream = new SequenceInputStream(enumeration);
        FileOutputStream fos = new FileOutputStream(targetFile);
        byte[] buf = new byte[1024];

        while ((length = inputStream.read(buf)) != -1) {
            fos.write(buf);
        }
        fos.close();
        inputStream.close();
    }
}
