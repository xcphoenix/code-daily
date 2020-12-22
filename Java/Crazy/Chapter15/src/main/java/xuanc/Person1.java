package xuanc;

/**
 * ClassName    Chapter15-Person1
 * Description  
 *
 * @author      xuanc
 * @date        19-5-6 下午8:05
 * @version     1.0
 */ 
public class Person1 implements java.io.Serializable {

    private String name;
    /**
     * 使用 transient 关键字修饰，可以指定 Java 序列化时无需实例化变量
     */
    private transient int age;

    /**
     * 没有提供无参数的构造器
     */
    public Person1(String name, int age) {
        System.out.println("有参数的构造器");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
