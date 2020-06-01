package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author      xuanc
 * @date        2020/2/17 下午6:08
 * @version     1.0
 */ 
public class ReflectMain {

    @SuppressWarnings({"rawtypes"})
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Constructor constructor = StaticInnerClassSingleton.class.getDeclaredConstructor();
        // 设置为可访问
        constructor.setAccessible(true);
        StaticInnerClassSingleton instance1 = (StaticInnerClassSingleton) constructor.newInstance();
        StaticInnerClassSingleton instance2 = (StaticInnerClassSingleton) constructor.newInstance();

        System.out.println(instance1 == instance2);
    }

}
