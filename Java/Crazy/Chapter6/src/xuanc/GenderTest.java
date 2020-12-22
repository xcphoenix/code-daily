package xuanc;

/**
 * ClassName    Chapter6-GenderTest
 * Description  枚举类的成员变量、方法和构造器
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-28 下午8:31
 */
public class GenderTest {

    public static void main(String[] args) {
        // 通过 Enum 的 valueOf() 方法来获得指定枚举类的枚举值
        Gender g = Enum.valueOf(Gender.class, "FEMALE");
        // 直接为枚举值的 name 实例变量赋值
        g.setName("女");
        System.out.println(g + " 代表 " + g.getName());
        g.setName("男");
        System.out.println(g + " 代表 " + g.getName());
    }

}
