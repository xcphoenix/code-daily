class Tester {
    static {
        System.out.println("Tester 类的静态初始化块...");
    }
}


/**
 * ClassName    Chapter18-ClassLoaderTest
 * Description  
 *
 * @author      xuanc
 * @date        19-4-24 下午8:11
 * @version     1.0
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader c1 = ClassLoader.getSystemClassLoader();
        c1.loadClass("Tester");
        System.out.println("系统加载 Tester 类");
        Class.forName("Tester");
    }
}
