package xuanc;

/**
 * ClassName    Chapter15-Person
 * Description  序列化
 *
 * @author      xuanc
 * @date        19-5-6 下午6:50
 * @version     1.0
 */ 
public class Person implements java.io.Serializable {

    private String name;
    private int age;

    /**
     * 没有提供无参数的构造器
     */
    public Person(String name, int age) {
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
