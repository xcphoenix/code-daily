package xuanc;

/**
 * ClassName    Chapter5-PersonTest
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-16 下午5:33
 */
public class PersonTest {
    public static void main(String[] args) {
        System.out.println("Person 的 eyeNum 类变量值： " + Person.eyeNum);
        // 创建  Person 对象
        Person p = new Person();
        System.out.println();
    }
}

class Person {
    public String name;
    public static int eyeNum;
}

