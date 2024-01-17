package cgg.spring.jdbc.jdbcclient.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.simple.JdbcClient;

@Configuration
@ComponentScan(basePackages = "cgg.spring.jdbc.jdbcclient.dao")
@PropertySource("db.properties")
public class JdbcClientConfig {

  @Value("${db.driverClassName}")
  String driverName;

  @Value("${db.url}")
  String url;

  @Value("${db.username}")
  String username;

  @Value("${db.password}")
  String password;

  @Bean("ds")
  BasicDataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(driverName);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
  }

  @Bean("jdbcClient")
  JdbcClient getJdbcClient() {
    JdbcClient jdbcClient = JdbcClient.create(getDataSource());
    return jdbcClient;
  }
}
