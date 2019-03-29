package xuanc;

/**
 * ClassName    Chapter6-FinalizeTest
 * Description  在 finalize() 方法中复活
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-28 下午10:27
 */
public class FinalizeTest {

    private static FinalizeTest ft = null;
    public void info() {
        System.out.println("测试资源清理的 finalize()");
    }
    public static void main(String[] args) throws Exception {
        // 创建 FinalizeTest() 对象立即进入可恢复状态
        new FinalizeTest();
        // 通知系统进行垃圾回收
        System.gc();
        // 强制垃圾回收机制调用可恢复对象的 finalize() 方法
        // Runtime.getRuntime().runFinalization();
        System.runFinalization();
        ft.info();
    }

    @Override
    public void finalize() {
        // 让 ft 引用到试图回收的可恢复对象，即可恢复对象重新变成可达
        ft = this;
    }
}
