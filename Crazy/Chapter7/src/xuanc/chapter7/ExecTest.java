package xuanc.chapter7;

/**
 * ClassName    Chapter7-ExecTest
 * Description  单独启动一个进程来运行操作系统的命令
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-29 下午10:22
 */
public class ExecTest {

    public static void main(String[] args) throws Exception {
        Runtime rt = Runtime.getRuntime();
        // 运行记事本程序
        rt.exec("code");
    }

}
