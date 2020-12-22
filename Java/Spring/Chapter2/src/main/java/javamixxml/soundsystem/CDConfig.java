package javamixxml.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName    Chapter2-CDConfig
 * Description  Java mix Xml
 *              将 BlankDisc 从 CDConfig 中拆分出来
 * @author xuanc
 * @version 1.0
 * @date 19-3-31 下午7:43
 */
@Configuration
public class CDConfig {

    @Bean
    public CompactDisc compactDisc(CompactDisc cd) {
        return cd;
    }
}
