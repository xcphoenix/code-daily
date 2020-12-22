package xuanc;

import java.io.IOException;

/**
 * ClassName    Chapter15-Person2
 * Description  
 *
 * @author      xuanc
 * @date        19-5-6 下午8:18
 * @version     1.0
 */ 
public class Person2 implements java.io.Serializable {

    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        // 将 name 反转
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        // 将读取的字符串反转后赋给 name 实例变量
        try {
            this.name = ((StringBuilder)in.readObject()).reverse().toString();
            this.age = in.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
