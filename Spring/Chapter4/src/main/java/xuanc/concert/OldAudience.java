package xuanc.concert;

import org.aspectj.lang.annotation.*;

/**
 * ClassName    Spring4-OldAudience
 * Description  [Old]　被<b>环绕通知</b>所代替
 *              使用 @Aspect 定义切面
 *              ------------------------------------------------
 *              使用 @Pointcut 注解在一个 @AspectJ切面内定义重用的切点
 *
 * @author      xuanc
 * @date        19-4-13 下午8:05
 * @version     1.0
 */
@Aspect
public class OldAudience {

    /**
     * 定义命名的切点
     * 所修饰的方法内容不重要，应当为空，方法本身只是一个标示
     */
    @Pointcut("execution(* xuanc.concert.Performance.perform(..))")
    public void performance() {}

    /**
     * 表演之前
     * ------
     * [old] @Before("execution(* xuanc.concert.Performance.perform(..))")
     */
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones.");
    }

    /**
     * 表演之前
     * ------
     * [old] @Before("execution(* xuanc.concert.Performance.perform(..))")
     */
    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    /**
     * 表演之后
     * -----
     * [old] @Before("execution(* xuanc.concert.Performance.perform(..))")
     */
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    /**
     * 表演失败之后
     * ---------
     * [old] @Before("execution(* xuanc.concert.Performance.perform(..))")
     */
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
