package xuanc.chapter7;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * ClassName    Chapter7-SystemTest
 * Description  System 类
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-29 下午10:00
 */
public class SystemTest {

    public static void main(String[] args) throws Exception {
        // 获取系统的所有的环境变量
        Map<String, String> env = System.getenv();
        for (String name : env.keySet()) {
            System.out.println(name + " ---> " + env.get(name));
        }
        // 获取指定环境变量
        System.out.println(System.getenv("JAVA_HOME"));
        // 获取所有的系统属性
        Properties props = System.getProperties();
        // 将所有的系统属性保存到 props.txt 文件中
        props.store(new FileOutputStream("/tmp/props.txt"), "System Properties");
        // 输出特定的系统属性
        System.out.println(System.getProperty("os.name"));
    }

}
