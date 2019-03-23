package xuanc;

/**
 * ClassName    Chapter6-CacheImmulateTest
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-23 下午4:04
 */
class CacheImmulate {
    private static int MAX_SIZE = 10;
    /**
     * 使用 <strong>类成员变量数组</strong> 来缓存已有的实例
     */
    private static CacheImmulate[] cache = new CacheImmulate[MAX_SIZE];
    /**
     * 记录缓存实例在缓存区的位置，cache[pos - 1] 是最新缓存的实例
     */
    private static int pos = 0;
    private final String name;

    private CacheImmulate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CacheImmulate valueOf(String name) {
        // 遍历以缓冲的对象
        for (int i = 0; i < MAX_SIZE; i++) {
            // 如果有相同的实例直接返回 => 先进先出原则
            if (cache[i] != null && cache[i].getName().equals(name)) {
                return cache[i];
            }
        }
        // 如果缓存区已满
        if (pos == MAX_SIZE) {
            cache[0] = new CacheImmulate(name);
            pos = 1;
        } else {
            cache[pos++] = new CacheImmulate(name);
        }
        return cache[pos - 1];
    }

    /**
     * 重写 equals()、hashCode() 方法
     *
     * @param obj 对象
     * @return 是否相同
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == CacheImmulate.class) {
            CacheImmulate ci = (CacheImmulate) obj;
            return name.equals(ci.getName());
        }
        return false;
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

public class CacheImmulateTest {
    public static void main(String[] args) {
        CacheImmulate c1 = CacheImmulate.valueOf("hello");
        CacheImmulate c2 = CacheImmulate.valueOf("hello");
        System.out.println(c1 == c2);
    }
}
