package cgg.springcore.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "spring.xml"
    );
    // ApplicationContext context = new AnnotationConfigApplicationContext(
    //   JavaConfig.class
    // );
    PaymentService bean = context.getBean("payment", PaymentService.class);
    Circle bean2 = context.getBean("circle", Circle.class);
    System.out.println(bean2.getName());
    // System.out.println(bean2.getNickName());
    //auth : payment started
    // bean.makePayment(5000);
  }
}
