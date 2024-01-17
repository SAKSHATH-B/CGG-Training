package cgg.springcore.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan(basePackages = "cgg.springcore.javaconfig")
public class JavaConfig {

  @Bean(name = { "student", "hell" })
  public Student getStudent() {
    return new Student(getSamosa());
  }

  @Bean
  public Samosa getSamosa() {
    return new Samosa();
  }
}
