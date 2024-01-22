package cgg.spring.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class MessageBeanPostProcessor1 implements BeanPostProcessor, Ordered {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
    throws BeansException {
    System.out.println(
      "MessageBeanPostProcessor1:postProcessBeforeInitialization:" + beanName
    );
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName)
    throws BeansException {
    System.out.println(
      "MessageBeanPostProcessor1:postProcessAfterInitialization:" + beanName
    );
    return bean;
  }

  @Override
  public int getOrder() {
    return 1;
  }
}
