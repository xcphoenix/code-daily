// Java 字符型学习

public class CharTest {
    public static void main(String[] args) {
        // 直接指定字符值
        char aChar = 'a';
        // 转义字符
        char enterChar = '\r';
        // 使用 Unicode编码值保存
        char ch = '\u9999';

        char zong = '名';
        int zongValue = zong;
        // 报告不必要的局部变量，这些变量不会增加方法的可理解性。捕获的变量包括立即返回的局部变量、
        // 立即分配给另一个变量然后不使用的局部变量以及始终与另一个局部变量或参数具有相同值的局部变量。

        System.out.println(aChar);
        System.out.println(enterChar);
        System.out.println(ch);
        System.out.println(zong);
        System.out.println(zongValue);
    }
}