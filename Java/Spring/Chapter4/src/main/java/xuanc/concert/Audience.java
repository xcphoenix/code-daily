package xuanc.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * ClassName    Spring4-Audience
 * Description  使用 @Aspect 定义切面
 *              ------------------------------------------------
 *              使用 @Pointcut 注解在一个 @AspectJ切面内定义重用的切点
 *
 *              ================================================
 *              * 使用环绕通知来重新实现切面                        *
 *
 * @author      xuanc
 * @date        19-4-13 下午8:05
 * @version     1.0
 */
@Aspect
public class Audience {

    /**
     * 定义命名的切点
     * 所修饰的方法内容不重要，应当为空，方法本身只是一个标示
     */
    @Pointcut("execution(* xuanc.concert.Performance.perform(..))")
    public void performance() {}

    /**
     * 环绕通知方法
     */
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }
}
