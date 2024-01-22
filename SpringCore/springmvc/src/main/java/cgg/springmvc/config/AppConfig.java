package cgg.springmvc.config;

import cgg.springmvc.entities.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "cgg.springmvc.*")
public class AppConfig {

  @Bean("viewResolver")
  InternalResourceViewResolver getViewResolver() {
    InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
    internalResourceViewResolver.setPrefix("/WEB-INF/views/");
    internalResourceViewResolver.setSuffix(".jsp");

    return internalResourceViewResolver;
  }

  @Bean("ds")
  DriverManagerDataSource getDataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.postgresql.Driver");
    ds.setUrl("jdbc:postgresql://localhost:5432/springmvcorm");
    ds.setUsername("postgres");
    ds.setPassword("postgres");
    return ds;
  }

  @Bean("factory")
  LocalSessionFactoryBean getFactory() {
    LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
    factory.setDataSource(getDataSource());
    Properties p = new Properties();
    p.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    p.put("hibernate.hbm2ddl.auto", "update");
    p.put("hibernate.format_sql", "true");
    p.put("hibernate.show_sql", "true");
    factory.setHibernateProperties(p);
    factory.setAnnotatedClasses(User.class);
    return factory;
  }

  @Bean("tx")
  HibernateTransactionManager getTransactionManager() {
    return new HibernateTransactionManager(
      (SessionFactory) getFactory().getObject()
    );
  }
}
