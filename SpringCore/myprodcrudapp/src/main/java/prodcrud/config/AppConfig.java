package prodcrud.config;

import jakarta.persistence.Basic;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "prodcrud.*")
public class AppConfig implements WebMvcConfigurer {

  @Bean
  InternalResourceViewResolver getViewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/views/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

  @Bean
  DriverManagerDataSource getSource() {
    DriverManagerDataSource source = new DriverManagerDataSource();
    source.setDriverClassName("org.postgresql.Driver");
    source.setUrl("jdbc:postgresql://localhost:5432/crudapp");
    source.setUsername("postgres");
    source.setPassword("postgres");
    return source;
  }

  @Bean
  LocalSessionFactoryBean getFactory() {
    LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
    factory.setDataSource(getSource());
    factory.setHibernateProperties(getHiberProp());
    factory.setPackagesToScan("prodcrud.*");
    return factory;
  }

  @Bean
  public Properties getHiberProp() {
    Properties p1 = new Properties();
    p1.setProperty(
      "hibernate.dialect",
      "org.hibernate.dialect.PostgreSQLDialect"
    );
    p1.setProperty("hibernate.hbm2ddl.auto", "update");
    p1.setProperty("hibernate.show_sql", "true");
    p1.setProperty("hibernate.format_sql", "true");
    return p1;
  }

  @Bean
  HibernateTransactionManager getTransaction() {
    return new HibernateTransactionManager(
      (SessionFactory) getFactory().getObject()
    );
  }
}
