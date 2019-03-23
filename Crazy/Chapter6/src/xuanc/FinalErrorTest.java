package xuanc;

/**
 * ClassName    Chapter6-FinalErrorTest
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-23 下午2:34
 */
public class FinalErrorTest {

    final int age;

    {
        // System.out.println(age);
        printAge();
        age = 6;
        System.out.println(age);
    }

    public void printAge() {
        System.out.println(age);
    }

    public static void main(String[] args) {
        new FinalErrorTest();
    }
}
