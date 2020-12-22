package xuanc.chapter7;

/**
 * ClassName    Chapter7-StringBuilderTest
 * Description  StringBuilder 类的使用
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-30 下午4:05
 */
public class StringBuilderTest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        // 追加字符串
        sb.append("java");
        // 插入
        sb.insert(0, "Hello");
        // 替换
        sb.replace(5, 6, ", ");
        // 删除
        sb.delete(5, 6);
        System.out.println(sb);
        // 反转
        sb.reverse();
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        // 改变 StringBuilder 的长度，将只保留前面部分
        sb.setLength(5);
        System.out.println(sb);
        // test
        sb.setLength(55);
        System.out.println(sb);
    }

}
