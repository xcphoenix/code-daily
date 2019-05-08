package xuanc.test;

import java.io.*;

/**
 * ClassName    Chapter15-ExampleTest
 * Description  
 *
 * @author      xuanc
 * @date        19-5-8 下午2:58
 * @version     1.0
 */ 
public class ExampleTest {

    public static void main(String[] args) {

        try (
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream("target/test1.txt")
                );
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("target/test1.txt")
                )
        ) {
            ExampleTwo exampleTwo = new ExampleTwo("john", 18, 2.3);
            oos.writeObject(exampleTwo);
            ExampleTwo getObject = (ExampleTwo)ois.readObject();

            System.out.println(exampleTwo == getObject);
            System.out.println(exampleTwo.getName());
            System.out.println(getObject.getName());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
