package xuanc;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * ClassName    Chapter15-Person3
 * Description  
 *
 * @author      xuanc
 * @date        19-5-6 下午8:29
 * @version     1.0
 */ 
public class Person3 implements Serializable {

    private String name;
    private int age;

    public Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * java 的序列化机制保证在序列化某个对象之前，先调用这个方法
     */
    private Object writeReplace() throws ObjectStreamException {
        ArrayList<Object> list = new ArrayList<>();
        list.add(name);
        list.add(age);
        return list;
    }

    /**
     * Setter and Getter
     */

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
