package cgg.springboot.multipledb.connmultipledb.config;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "entityManagerFactoryBean2",
  basePackages = { "cgg.springboot.multipledb.connmultipledb.repo" },
  transactionManagerRef = "transactionManager2"
)
public class MySqlDbConfig {

  @Autowired
  private Environment env;

  @Bean(name = "dataSource2")
  DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl(env.getProperty("spring.datasource.url"));
    dataSource.setDriverClassName(
      env.getProperty("spring.datasource.driver-class-name")
    );
    dataSource.setUsername(env.getProperty("spring.datasource.username"));
    dataSource.setPassword(env.getProperty("spring.datasource.password"));
    return dataSource;
  }

  //entityMangerFactory
  @Bean(name = "entityManagerFactoryBean2")
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

    em.setDataSource(dataSource());
    em.setPackagesToScan("cgg.springboot.multipledb.connmultipledb.entities");

    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    Map<String, String> properties = new HashMap<>();
    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    properties.put("hibernate.show_sql", "true");
    properties.put("hibernate.format_sql", "true");
    properties.put("hibernate.hbm2ddl.auto", "update");
    em.setJpaPropertyMap(properties);
    return em;
  }

  @Bean(name = "transactionManager2")
  PlatformTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(
      entityManagerFactoryBean().getObject()
    );
    return transactionManager;
  }
}
