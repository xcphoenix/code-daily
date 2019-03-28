package xuanc.chapter8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * ClassName    Chapter8-CollectionTest
 * Description  Collection
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-27 下午9:53
 */
public class CollectionTest {

    public static void main(String[] args) {
        Collection c = new ArrayList();
        // 添加元素
        c.add("swk");
        // 集合里不能放基本类型的值，但 Java 支持自动装箱
        c.add(6);
        System.out.println("c 集合里的元素个数为：" + c.size());
        c.remove(6);
        System.out.println("c 集合里的元素个数为：" + c.size());
        // 判断是否包含指定字符串
        System.out.println("c 集合是否包含 \"swk\" " + c.contains("swk"));
        c.add("qlj");
        System.out.println("c 集合中的元素 " + c);
        Collection books = new HashSet();
        books.add("qlj");
        System.out.println("c 集合是否完全包含 books 集合 " + c.containsAll(books));
        // 相减
        c.removeAll(books);
        System.out.println("c 集合里的元素：" + c);
        c.clear();
        System.out.println("c :" + c);
        books.retainAll(c);
        System.out.println("books " + books);
    }
}
