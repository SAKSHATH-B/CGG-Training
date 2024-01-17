package cgg.spring.jdbc.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Configuration
@ComponentScan(
  basePackages = { "cgg.spring.jdbc.dao", "cgg.spring.jdbc.service" }
)
@PropertySource("db.properties")
public class JdbcConfig {

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

  @Bean("jdbcTemplate")
  JdbcTemplate getJdbcTemplate() {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
    return jdbcTemplate;
  }

  //   @Bean("studentDao")
  //   StudentDao getStudentDao() {
  //     StudentDaoImpl studentDao = new StudentDaoImpl();
  //     studentDao.setJdbcTemplate(getJdbcTemplate());
  //     return studentDao;
  //   }

  // @Bean("jdbcTemplate")
  // NamedParameterJdbcTemplate getNamedJdbcTemplate() {
  //   NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
  //     getDataSource()
  //   );
  //   return namedParameterJdbcTemplate;
  // }

  @Bean("simpleJdbcCall")
  SimpleJdbcCall getJdbcCall() {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(getDataSource());
    return simpleJdbcCall;
  }
}
