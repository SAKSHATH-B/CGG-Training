package cgg.spring.ormvc.config;

import cgg.spring.ormvc.entities.User;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "cgg.spring.ormvc.dao")
@EnableTransactionManagement
public class HibernateConfig {

  @Bean("ds")
  DriverManagerDataSource getSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.postgresql.Driver");
    ds.setUrl("jdbc:postgresql://localhost:5432/springjdbc");
    ds.setUsername("postgres");
    ds.setPassword("postgres");
    return ds;
  }

  @Bean("factory")
  LocalSessionFactoryBean factory() {
    LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
    factory.setDataSource(getSource());
    factory.setHibernateProperties(hibernateProperties());
    factory.setAnnotatedClasses(User.class);
    return factory;
  }

  @Bean("transactionManager")
  HibernateTransactionManager hibernateTransactionManager() {
    return new HibernateTransactionManager(factory().getObject());
  }

  Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.setProperty(
      "hibernate.dialect",
      "org.hibernate.dialect.PostgreSQLDialect"
    );
    properties.setProperty("hibernate.hbm2ddl.auto", "update");
    properties.setProperty("hibernate.show_sql", "true");
    properties.setProperty("hibernate.format_sql", "true");
    return properties;
  }
}
