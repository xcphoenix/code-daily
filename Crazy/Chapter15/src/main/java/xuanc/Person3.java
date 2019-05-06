package xuanc;

import java.io.IOException;

/**
 * ClassName    Chapter15-Person3
 * Description  
 *
 * @author      xuanc
 * @date        19-5-6 下午8:29
 * @version     1.0
 */ 
public class Person3 {

    private String name;
    private int age;

    public Person3(String name, int age) {
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
