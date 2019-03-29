package xuanc;

import java.lang.ref.WeakReference;

/**
 * ClassName    Chapter6-ReferenceTest
 * Description  弱引用所引用的对象被系统垃圾回收的过程
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-29 下午8:48
 */
public class ReferenceTest {

    public static void main(String[] args) throws Exception{
        // 创建一个字符串对象
        String str = new String("疯狂 Java 讲义");
        // 创建一个弱引用，让此弱引用引用到 str
        WeakReference wr = new WeakReference(str);
        // 切断 str 引用与 "疯狂 Java 讲义" 字符串之间的引用
        str = null;
        // 取出弱引用所引用的对象
        System.out.println(wr.get());
        // 强制垃圾回收
        System.gc();
        // 强制调用 finalize() 方法
        System.runFinalization();
        // 再次取出弱引用所引用的对象
        System.out.println(wr.get());
    }

}
