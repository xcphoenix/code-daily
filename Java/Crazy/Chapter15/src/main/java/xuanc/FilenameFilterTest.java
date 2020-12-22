package xuanc;

import java.io.File;

/**
 * ClassName    Chapter15-FilenameFilterTest
 * Description  文件过滤器
 *
 * @author      xuanc
 * @date        19-4-7 下午3:26
 * @version     1.0
 */ 
public class FilenameFilterTest {

    public static void main(String[] args) {
        File file = new File(".");
        // 使用 Lambda 表达式（目标类型为 FilenameFilter）实现文件过滤器
        String[] nameList = file.list(
                (dir, name) -> name.endsWith(".java") || new File(name).isDirectory()
        );
        if (nameList != null) {
            for (String name : nameList) {
                System.out.println(name);
            }
        }
    }

}
