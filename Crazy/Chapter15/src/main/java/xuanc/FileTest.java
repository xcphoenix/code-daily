package xuanc;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * ClassName    Chapter15-FileTest
 * Description  测试 File 类的功能
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-3 下午7:24
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        // 以当前路劲来创建一个 File 对象
        File file = new File(".");
        // 直接获取文件名
        System.out.println(file.getName());
        // 获取相对路径的父路径（可能会出错）
        System.out.println(file.getParent());
        // 获取绝对路径
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        // 获取上一级路径
        System.out.println(file.getAbsoluteFile().getParent());
        // 在当前路径下创建一个临时文件
        File tmpFile = File.createTempFile("aaa", ".txt", file);
        // 指定当 JVM 退出时删除文件
        tmpFile.deleteOnExit();
        // 以系统当前的时间作为新文件名来创建新文件
        File newFile = new File(System.currentTimeMillis() + "");
        System.out.println("newFile 对象是否存在：" + newFile.exists());
        // 以指定 newFile 对象来创建一个文件
        newFile.createNewFile();
        // 以 newFile 对象来创建一个目录
        // 因为已存在，会创建失败
        newFile.mkdir();
        // 使用 list 方法来列出当前路劲下的所有文件和路径
        String[] fileList = file.list();
        System.out.println("==== 当前路径下的所有文件为 ====");
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
        // listRoots() 静态方法列出所有的磁盘根路径
        File[] roots = File.listRoots();
        System.out.println("==== 系统所有的根路径如下 ====");
        for (File root : roots) {
            System.out.println(root);
        }

    }

}
