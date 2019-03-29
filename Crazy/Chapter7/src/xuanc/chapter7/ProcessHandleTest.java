package xuanc.chapter7;

/**
 * ClassName    Chapter7-ProcessHandleTest
 * Description  ProcessHandle.Info 类
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-29 下午10:26
 */
public class ProcessHandleTest {

    public static void main(String[] args) throws Exception {
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("Code");
        ProcessHandle ph = p.toHandle();
    }

}
