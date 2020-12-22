package xuanc.chapter7;

/**
 * ClassName    Chapter7-RuntimeTest
 * Description  Runtime 代表 Java 运行时环境
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-29 下午10:16
 */
public class RuntimeTest {

    public static void main(String[] args) {
        // 获取 Java 程序相关联的运行时对象
        Runtime rt = Runtime.getRuntime();

        System.out.println("处理器数量: " + rt.availableProcessors());
        System.out.println("空闲内存数: " + rt.freeMemory());
        System.out.println("可用最大内存数：" + rt.maxMemory());
    }

}
