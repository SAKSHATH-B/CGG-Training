package com.stackroute.keepnote.config;

import com.stackroute.keepnote.model.Note;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class ApplicationContextConfig {

  @Bean("ds")
  DriverManagerDataSource getDataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.postgresql.Driver");
    ds.setUrl("jdbc:postgresql://localhost:5432/test");
    ds.setUsername("postgres");
    ds.setPassword("postgres");
    return ds;
  }

  @Bean("factory")
  LocalSessionFactoryBean getFactory() {
    LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
    factory.setDataSource(getDataSource());
    factory.setHibernateProperties(properties());
    factory.setAnnotatedClasses(Note.class);
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
}
