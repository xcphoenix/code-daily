package xuanc.convert_xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * ClassName    Spring4-EncoreableIntroducer
 * Description  为了实现　给所有的 Performance 实现引入 Encoreable 接口
 *              创建一个切面来完成
 * @author      xuanc
 * @date        19-4-17 下午3:45
 * @version     1.0
 */
@Component
public class EncoreableIntroducer {

    public static Encoreable encoreable;
}
