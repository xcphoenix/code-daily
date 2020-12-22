package xuanc;

class Base {
    String name = "HelloWorld";

    public Base() {
        test();
    }

    public void test() {
        System.out.println("将被子类覆盖的方法");
    }
}

/**
 * ClassName    Chapter5-Sub
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-21 下午6:41
 */
public class Sub extends Base {
    String name = "test";

    @Override
    public void test() {
        System.out.println("子类重写父类的方法. name = " + name);
    }

    public static void main(String[] args) {
        Base base = new Sub();
        System.out.println(base.name);
    }
}
