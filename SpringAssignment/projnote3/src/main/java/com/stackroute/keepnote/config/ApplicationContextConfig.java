package com.stackroute.keepnote.config;

import com.stackroute.keepnote.model.Category;
import com.stackroute.keepnote.model.Note;
import com.stackroute.keepnote.model.Reminder;
import com.stackroute.keepnote.model.User;
import java.util.List;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableWebMvc
@ComponentScan(basePackages = "com.stackroute.keepnote.*")
public class ApplicationContextConfig implements WebMvcConfigurer {

  @Bean("ds")
  DriverManagerDataSource getDataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.postgresql.Driver");
    ds.setUrl("jdbc:postgresql://localhost:5432/springasmt");
    ds.setUsername("postgres");
    ds.setPassword("postgres");
    return ds;
  }

  @Bean("factory")
  LocalSessionFactoryBean getFactory() {
    LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
    factory.setDataSource(getDataSource());
    factory.setHibernateProperties(properties());
    factory.setAnnotatedClasses(
      Note.class,
      User.class,
      Category.class,
      Reminder.class
    );
    return factory;
  }

  private Properties properties() {
    Properties properties = new Properties();
    properties.put("hibernate.hbm2ddl.auto", "update");
    properties.put("hibernate.format_sql", "true");
    properties.put("hibernate.show_sql", "true");
    return properties;
  }

  @Bean("tx")
  HibernateTransactionManager getTransactionManager() {
    return new HibernateTransactionManager(
      (SessionFactory) getFactory().getObject()
    );
  }

  @Bean("viewResolver")
  InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }

  @Bean
  public MappingJackson2HttpMessageConverter jsonMessageConverter() {
    return new MappingJackson2HttpMessageConverter();
  }

  @Override
  public void configureMessageConverters(
    List<HttpMessageConverter<?>> converters
  ) {
    converters.add(jsonMessageConverter());
  }
}
