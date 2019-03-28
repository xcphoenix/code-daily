package xuanc.chapter8;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName    Chapter8-MapTest
 * Description  Map 基本功能
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-27 下午5:12
 */
public class MapTest {

    public static void main(String[] args) {
        Map map = new HashMap();
        // 成对放入多个 key-value 对
        map.put("Crazy1", 109);
        map.put("Crazy2", 10);
        map.put("Crazy3", 19);
        map.put("Crazy4", 19);
        System.out.println(map);
        // put() 方法
        System.out.println(map.put("Crazy1", 222));
        System.out.println(map);
        System.out.println(map.put("Crazy5", 55));
        System.out.println(map);
        System.out.println("Key has 'Crazy2' ? " + map.containsKey("Crazy2"));
        System.out.println("Value is 19 ? " + map.containsValue(19));
        // 获取 key 组成的集合
        for (Object key : map.keySet()) {
            System.out.println(key + "-->" + map.get(key));
        }
        map.remove("Crazy1");
        System.out.println(map);
    }

}
