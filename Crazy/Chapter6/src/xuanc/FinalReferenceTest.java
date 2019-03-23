package xuanc;

import java.util.Arrays;

class Person {
    private int age;
    public Person() {}
    public Person(int age) {
        this.age = age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}

/**
 * ClassName    Chapter6-FinalReferenceTest
 * Description  final 修饰引用类型变量
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-23 下午2:47
 */
public class FinalReferenceTest {

    public static void main(String[] args) {
        // final 修饰数组变量
        final int[] iArr = {5, 6, 12, 9};
        System.out.println(Arrays.toString(iArr));
        // 对数组排序
        Arrays.sort(iArr);
        System.out.println(Arrays.toString(iArr));
        iArr[2] = -8;
        System.out.println(Arrays.toString(iArr));
        // iArr = null;
        final Person p = new Person(45);
        p.setAge(23);
        System.out.println(p.getAge());
        // p = null;
    }
}
