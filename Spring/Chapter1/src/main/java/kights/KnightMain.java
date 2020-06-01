package kights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName    Spring1-KnightMain
 * Description  KnightMain 加载包含 Knight 的 Spring 上下文
 * @author      xuanc
 * @date        19-3-18 下午4:33
 * @version     1.0
 */ 
public class KnightMain {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("knights.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
