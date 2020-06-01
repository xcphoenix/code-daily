package xuanc.chapter7;

import java.util.concurrent.CompletableFuture;

/**
 * ClassName    Chapter7-ProcessHandleTest
 * Description  ProcessHandle.Info 类
 *              可以通过 Java 9 的 ProcessHandle 接口来获取进程的 ID，父进程和后代进程，
 *              通过该接口的 onExit() 方法可以在进程结束时完成某些行为
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-29 下午10:26
 */
public class ProcessHandleTest {

    public static void main(String[] args) throws Exception {
        Runtime rt = Runtime.getRuntime();
        // 执行 Code 进程
        Process p = rt.exec("code");
        ProcessHandle ph = p.toHandle();
        System.out.println("进程是否运行：" + ph.isAlive());
        System.out.println("进程 ID：" + ph.pid());
        System.out.println("父进程：" + ph.parent());
        // 获取 ProcessHandle.Info 信息
        ProcessHandle.Info info = ph.info();
        // 通过 ProcessHandle.Info 信息来获取进程相关信息
        System.out.println("进程命令：" + info.command());
        System.out.println("进程参数：" + info.arguments());
        System.out.println("进程启动时间：" + info.startInstant());
        System.out.println("进程累计运行时间：" + info.totalCpuDuration());
        // 通过 CompletableFuture 在进程结束时运行某个任务
        CompletableFuture<ProcessHandle> cf = ph.onExit();
        cf.thenRunAsync( () -> System.out.println("程序退出"));
        Thread.sleep(5000);
    }

}
