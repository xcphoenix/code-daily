package xuanc.test;

/**
 * ClassName    Chapter15-Example
 * Description  
 *
 * @author      xuanc
 * @date        19-5-8 下午12:59
 * @version     1.0
 */ 
public class Example implements java.io.Serializable {

    private String name;
    private int age;

    public Example() { }

    public Example(String name, int age) {
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
