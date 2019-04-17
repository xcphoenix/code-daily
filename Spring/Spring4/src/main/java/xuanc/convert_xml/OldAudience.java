package xuanc.convert_xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * ClassName    Spring4-OldAudience
 * Description  用 xml 来声明切面
 * 　　　　　　　　---------------
 *              移除所有的 AspectJ 注解
 * @author      xuanc
 * @date        19-4-13 下午8:05
 * @version     1.0
 */
public class OldAudience {

    public void silenceCellPhones() {
        System.out.println("Silencing cell phones.");
    }

    public void takeSeats() {
        System.out.println("Taking seats");
    }

    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
