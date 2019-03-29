package xuanc.chapter7;

/**
 * ClassName    Chapter7-ArgsTest
 * Description  运行 Java 程序中的参数
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-29 下午9:23
 */
public class ArgsTest {

    public static void main(String[] args) {
        System.out.println(args.length);
        for (String arg : args) {
            System.out.println(arg);
        }
    }

}
