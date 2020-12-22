package kights;

import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * ClassName    Spring1-BraveKnightTest
 * Description  使用 mock 测试
 * @author      xuanc
 * @date        19-3-18 下午3:33
 * @version     1.0
 */ 
public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest() {
        /*
         * 使用Mockito的静态方法mock，我们就可以创建一个类的mock实例，
         * 这个mock实例拥有 Quest 的所有方法接口，并且给这些方法以最基本的实现
         * --------------------------------------------------------
         *   创建 mock Quest
         *   Quest.class 编译时获取类名
         */
        Quest mockQuest = mock(Quest.class);
        // 注入 mock Quest
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        // Mockito提供 verify 关键字来实现校验方法是否被调用
        // 验证对象的方法得到了一次调用
        verify(mockQuest, times(1)).embark();
    }
}
