package xuanc.chapter7;

class Address {
    String detail;
    public Address(String detail) {
        this.detail = detail;
    }
}

/**
 * @author xuanc
 * Description:  实现 Cloneable 接口，Cloneable 是一个标记性的接口，接口里没有定义任何方法
 */
class User implements Cloneable {
    int age;
    Address address;
    public User(int age) {
        this.age = age;
        address = new Address("广州天河");
    }
    /**
     *  通过调用 super.clone() 来实现 clone() 方法
     */
    @Override
    public User clone() throws CloneNotSupportedException {
        return (User)super.clone();
    }
}

/**
 * ClassName    Chapter7-CloneTest
 * Description  自我克隆
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-30 下午3:35
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        User u1 = new User(29);
        // clone 得到 u1 对象的副本
        User u2 = u1.clone();
        // 判断 u1, u2 是否相同
        System.out.println(u1 == u2);
        // 判断 u1, u2 的 address 是否相同
        System.out.println(u1.address == u2.address);
    }

}
