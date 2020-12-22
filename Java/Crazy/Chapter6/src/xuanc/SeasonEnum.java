package xuanc;

/**
 * @author xuanc
 */
public enum SeasonEnum {
    /*
     * enum 定义的类默认继承 Object 类，所以不能显示继承其他父类
     * enum 的非抽象的枚举类默认使用 final 修饰，所以枚举类不能派生子类
     * 构造器只能用 private 修饰（默认）
     * 枚举类的所有实例必须在枚举类的第一行显示列出（默认：public static final）
     */

    SPRING, SUMMER, FALL, WINTER;
}
