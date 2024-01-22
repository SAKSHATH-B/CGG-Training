package cgg.spring.orm.config;

import cgg.spring.orm.entities.Student;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "cgg.spring.orm.dao")
@PropertySource("db.properties")
public class JavaConfig {

  @Value("${db.driverClassName}")
  String driverName;

  @Value("${db.url}")
  String url;

  @Value("${db.username}")
  String username;

  @Value("${db.password}")
  String password;

  @Bean("ds")
  DriverManagerDataSource getSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(driverName);
    ds.setUrl(url);
    ds.setUsername(username);
    ds.setPassword(password);
    // ds.setDriverClassName("org.postgresql.Driver ");
    // ds.setUrl("jdbc:postgresql://localhost:5432/springjdbc");
    // ds.setUsername("postgres");
    // ds.setPassword("postgres");
    return ds;
  }

  @Bean("factory")
  LocalSessionFactoryBean factory() {
    LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
    factory.setDataSource(getSource());
    factory.setHibernateProperties(hibernateProperties());
    factory.setAnnotatedClasses(Student.class);
    return factory;
  }

  @Bean("hibernateTemplate")
  HibernateTemplate hibernateTemplate() {
    return new HibernateTemplate(factory().getObject());
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
