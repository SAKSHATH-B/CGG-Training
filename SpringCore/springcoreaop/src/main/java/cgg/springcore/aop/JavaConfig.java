package cgg.springcore.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
// @ComponentScan(basePackages = "cgg.springcore.aop")
@EnableAspectJAutoProxy
public class JavaConfig {

  @Bean(name = { "payment" })
  public PaymentService getPayment() {
    return new PaymentServiceImpl();
  }

  @Bean(name = { "myAspect" })
  public MyAspect getAspect() {
    return new MyAspect();
  }
}
