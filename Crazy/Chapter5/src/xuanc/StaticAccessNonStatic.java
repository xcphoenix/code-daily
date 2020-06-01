package xuanc;
/**
 * ClassName    Chapter5-StaticAccessNonStatic
 * Description  TODO
 * @author      xuanc
 * @date        19-3-16 下午4:54
 * @version     1.0
 */ 
public class StaticAccessNonStatic {
    public void info() {
        System.out.println("简单的 info 方法");
    }
    public static void main(String[] args) {
        new StaticAccessNonStatic().info();
    }
}
