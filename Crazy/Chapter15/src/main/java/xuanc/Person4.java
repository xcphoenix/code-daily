package xuanc;

import java.io.*;

/**
 * ClassName    Chapter15-Person4
 * Description  另一种序列化机制
 *
 * @author      xuanc
 * @date        19-5-7 下午3:35
 * @version     1.0
 */ 
public class Person4 implements Externalizable {

    private String name;
    private int age;

    /**
     * 必须提供无参数的构造器，不然反序列化时会失败
     */
    public Person4() {}

    public Person4(String name, int age) {
        System.out.println("有参数的构造器");
        this.name = name;
        this.age = age;
    }

    /**
     * Setter and Getter Method ...
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

    /**
     * 实现自定义序列化
     */

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // 将 name 实例变量值反转后写入二进制流
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // 将读取的字符串反转后给 name 变量
        this.name = ((StringBuilder)in.readObject()).reverse().toString();
        this.age = in.readInt();
    }
}
