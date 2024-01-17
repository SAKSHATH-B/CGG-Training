package cgg.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  public static void main(String[] args) {
    // BeanFactory factory = new XmlBeanFactory(
    //   new FileSystemResource("spring.xml")
    // );

    //using lifecycle methods
    // AbstractApplicationContext context = new ClassPathXmlApplicationContext(
    //   "spring.xml"
    // );
    // context.registerShutdownHook();

    ApplicationContext context = new ClassPathXmlApplicationContext(
      "spring.xml"
    );
    Shape shape = (Shape) context.getBean("circle");
    shape.draw();
  }
}
