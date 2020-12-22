import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * ClassName    Chapter18-ClassLoaderPropTest
 * Description  
 *
 * @author      xuanc
 * @date        19-4-24 下午8:29
 * @version     1.0
 */ 
public class ClassLoaderPropTest {
    public static void main(String[] args) throws IOException {
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器：" + systemLoader);
        /**
         * 获取系统类加载器的加载路径——通常由 CLASSPATH 环境变量指定
         * 如果操作系统没有指定 CLASSPATH 环境变量，则默认以当前路径作为类加载器的加载路径
         */
        Enumeration<URL> em1 = systemLoader.getResources("");
    }
}
