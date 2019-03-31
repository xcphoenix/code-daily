package javamixxml.soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * ClassName    Chapter2-CDPlayerTest
 * Description  测试组扫描可以发现 CompactDisc
 * @author      xuanc
 * @date        19-3-18 下午10:22
 * @version     1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    private MediaPlayer player;

    @Test
    public void cdShouldNotBeNull() {
        // 断言: cd 不为 null
        assertNotNull(cd);
    }

    @Test
    public void play() {
        player.play();
        assertEquals(
                "Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n" +
                        "-Track: Sgt. Pepper's Lonely Hearts Club Band\n" +
                        "-Track: With a Little Help from My Friends\n" +
                        "-Track: Lucy in the Sky with Diamonds\n",
                log.getLog()
        );
    }
}

/*
 * 使用了 SpringJUnit4ClassRunner 以便在测试开始时自动创建 Spring 的应用上下文
 * @ContextConfiguration　注解告诉需要在 CDPlayConfig 中加载配置
 * －－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
 * @Autowired 注解以便将 CompactDisc bean 注入到测试代码中
 */