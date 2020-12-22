package xuanc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ClassName    Chapter14-ErrorUtils
 * Description  堆污染警告
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-1 下午10:20
 */
public class ErrorUtils {

    public static void faultyMethod(List<String>... listStrArray) {
        // Java 不允许创建泛型数组，因此 listArray 只能被当成 List[] 处理
        List[] listArray = listStrArray;
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(new Random().nextInt(100));
        // 把 listArray 的第一个元素赋值为 myArray
        listArray[0] = myList;
        String s = listStrArray[0].get(0);
    }

}
