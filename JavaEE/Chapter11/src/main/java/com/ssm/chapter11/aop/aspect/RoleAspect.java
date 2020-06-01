package com.ssm.chapter11.aop.aspect;

import com.ssm.chapter11.game.pojo.Role;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * ClassName    Chapter11-RoleAspect
 * Description  创建切面
 *
 * @author      xuanc
 * @date        19-5-24 下午9:53
 * @version     1.0
 */
@Aspect
public class RoleAspect {

    /**
     * 定义一个切点来防止多次重复
     */
    @Pointcut("execution(* com.ssm.chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void print() {}

    @Before(value = "print() && args(role)", argNames = "role")
    public void before(Role role) {
        System.out.println("before... [test = " + role.getClass().getName() + " ]");
    }

    @After("print())")
    public void after() {
        System.out.println("after...");
    }

    @AfterReturning("print()")
    public void afterReturning() {
        System.out.println("after returning...");
    }

    @AfterThrowing("print()")
    public void afterThrowing() {
        System.out.println("after throwing...");
    }

    /**
     * 加入环绕通知
     * ------------
     * 不会覆盖其他的【通知】，比其他的通知要早
     */
    // @Around("print()")
    // public void around(ProceedingJoinPoint jp) {
    //     System.out.println("# around before ...");
    //     try {
    //         jp.proceed();
    //     } catch (Throwable e) {
    //         e.printStackTrace();
    //         System.out.println("# around throwing ... ");
    //     }
    //     System.out.println("# around after ... ");
    // }
}
