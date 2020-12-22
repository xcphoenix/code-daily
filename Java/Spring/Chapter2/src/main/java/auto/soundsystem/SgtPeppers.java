package auto.soundsystem;

import org.springframework.stereotype.Component;
import javax.inject.Named;

// @Component　注解表明该类会作为组件类，并告知 Spring 要为这个类创建 bean
// Spring 上下文所有的 bean 都会有一个 ID，默认将类名的第一个字母小写当做其 ID
// 也可以使用　@Component("ID 名") 来将期望的 ID 传给注解
// 也可以使用 Java 依赖注入规范所提供的 @Named 注解为 bean 设置 ID
/**
 * ClassName    Chapter2-SgtPeppers
 * Description  创建 CompactDisc 的一个实现
 * @author      xuanc
 * @date        19-3-18 下午9:59
 * @version     1.0
 */
// @Component("sgtPeppers")
@Component
@Named("sgtPeppers")
public class SgtPeppers implements CompactDisc{

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
