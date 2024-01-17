package cgg.spring.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(
    ConfigurableListableBeanFactory beanFactory
  ) throws BeansException {
    System.out.println("Bean Factory post processor is called...");
  }
}
