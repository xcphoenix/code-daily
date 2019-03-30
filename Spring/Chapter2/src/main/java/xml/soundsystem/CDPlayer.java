package xml.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Named;

/**
 * ClassName    Chapter2-CDPlayer
 * Description  通过为 bean 添加注解实现自动装配
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-19 下午8:22
 */
public class CDPlayer implements MediaPlayer {

    private CompactDisc compactDisc;

    public void setCompactDisc (CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play() {
        compactDisc.play();
    }
}
/*
 * @Component 注解表明该类是个 bean
 * 自动装配：在满足依赖的过程中，会在 Spring 上下文中寻找匹配某个 bean 需求的其他 bean，自动装配需要 @Autowired 注解
 * --------------------------------------------------------------------------------------------------
 * @Autowired 注解可以出现在类的任何方法上
 * Spring 初始化 bean 之后，会尽可能的满足依赖，如果有且只有一个
 */