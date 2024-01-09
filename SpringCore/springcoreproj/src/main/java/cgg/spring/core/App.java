package cgg.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    // BeanFactory factory = new XmlBeanFactory(
    //   new FileSystemResource("spring.xml")
    // );

    ApplicationContext context = new ClassPathXmlApplicationContext(
      "spring.xml"
    );
    Triangle triangle = (Triangle) context.getBean("triangle");
    triangle.draw();
  }
}
