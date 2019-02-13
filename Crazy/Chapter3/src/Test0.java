// 数据类型测试

public class Test0 {
    public static void main(String[] args) {
        // 把整数值当 long 处理，加上L后缀
        long tmp0 = 1234567891011L;
        System.out.println(tmp0);

        // 基本类型－整数
        // :: 进制表示方法
        int eight = 0654;
        // report: 有些编码标准禁止使用八进制文字，因为它们很容易与十进制文字混淆。
        int binVal1 = 0b11;
        // byte binVal2 = 0B10000000;
        // 会发生错误，默认的数值是 int，B后面的1不是符号位，会发生溢出
        // 定义一个32位的二进制整数
        int binVal3 = 0B10000000000000000000000000000011;
        // 这里32位最高位为符号位，符号位为１，所以是负数，负数用补码存放

        System.out.println(binVal1);
//        System.out.println(binVal2);
        System.out.println(binVal3);
    }
}