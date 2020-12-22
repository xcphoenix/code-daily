// Java 字符型学习
// ==============================================
// 类型               第一位　　指数　　尾数　　长度
// ----------------------------------------------
// float(后缀：f&F)   符号位    8位　　23位   ４字节
// double(default)   符号位    11位  52位　　８字节
// ==============================================
// ...
// 三个特殊值: 正无穷、负无穷、非数
// 正无穷: Double(Float).POSITIVE_INFINITY
// 负无穷: Double(Float.)NEGATIVE_INFINITY
// 非数：Double(Float).NAN   (NAN可以和任何数都不相等)

public class FloatTest
{
    public static void main(String[] args) {
        float af = 5.2345556f;
        // af 值发生变化
        System.out.println(af);
        double a = 0.0;
        double c = Double.NEGATIVE_INFINITY;
        float d = Float.NEGATIVE_INFINITY;
        System.out.println(c == d);
        System.out.println(a / a);
    }
}