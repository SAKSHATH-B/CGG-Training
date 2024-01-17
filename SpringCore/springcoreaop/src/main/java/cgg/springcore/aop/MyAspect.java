package cgg.springcore.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

// @Aspect
// @Component
public class MyAspect {

  // @Before("execution(* cgg.springcore.aop.PaymentServiceImpl.makePayment(..))")
  // public void printBefore() {
  //   System.out.println("Payment Started");
  // }

  // @After("execution(* cgg.springcore.aop.PaymentServiceImpl.makePayment(..))")
  // public void printAfter() {
  //   System.out.println("Payment done");
  // }

  // @Before("pointcut()")
  // public void bef() {
  //   System.out.println(
  //     "Advice method is called and getName() is started its execution..."
  //   );
  // }

  // @Before("execution(* cgg.springcore.aop.Circle.*())")
  // public void bef2() {
  //   System.out.println("Advice method 2...");
  // }

  // @Around("@annotation(cgg.springcore.aop.Loggable)")
  // @Around("pointcut()")
  public void aroundadvice(ProceedingJoinPoint proceedingJoinPoint) {
    try {
      System.out.println("Before advice");
      proceedingJoinPoint.proceed();
      System.out.println("After advice");
    } catch (Throwable e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("after finally");
  }

  // @Pointcut("execution(* get*())")
  public void pointcut() {}
  // @AfterReturning("execution(* cgg.springcore.aop.Circle.*())")
  // public void afr() {
  //   System.out.println(
  //     "Advice method ran and name of circle has been printed..."
  //   );
  // }

  // @Before("allCircleMethods()")
  // public void beforeCircleImpl(JoinPoint joinPoint) {
  //   System.out.println("Advice 1 for " + joinPoint);
  // }

  // @Pointcut("within(cgg.springcore.aop.Circle)")
  // public void allCircleMethods() {}
}
