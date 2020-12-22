package xuanc;

class BaseClass {
    public int book = 6;
    public void base() {
        System.out.println("父类的普通方法");
    }
    public void test() {
        System.out.println("父类的被覆盖方法");
    }
}

/**
 * ClassName    Chapter5-SubClass
 * Description  多态性
 * @author xuanc
 * @version 1.0
 * @date 19-3-17 下午5:16
 */
public class SubClass extends BaseClass{
    // 重新定义 book 实例变量来隐藏父类的实例变量
    public String book = "轻量级 Java EE 企业应用实战";
    @Override
    public void test() {
        System.out.println("子类覆盖父类的方法" + book);
    }
    public void sub() {
        System.out.println("子类的普通方法" + book);
    }
    public static void main(String[] args) {
        BaseClass bc = new BaseClass();
        System.out.println(bc.book);
        bc.base();
        bc.test();
        SubClass sc = new SubClass();
        System.out.println(sc.book);
        sc.base();
        sc.test();
        // 多态！
        BaseClass ploymophicBc = new SubClass();
        System.out.println(ploymophicBc.book);
        ploymophicBc.base();
        ploymophicBc.test();
    }
}
