package cgg.thymeleaf.thymeleafproj.dao;

import cgg.thymeleaf.thymeleafproj.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public int createTable() {
    int update = jdbcTemplate.update(
      "create table if not exists user1(user_id int primary key,user_name varchar(100),user_age int, user_city varchar(100))"
    );
    return update;
  }

  @Override
  public int createUser(User user) {
    String query = "insert into user1 values(?,?,?,?)";
    int update = jdbcTemplate.update(
      query,
      new Object[] {
        user.getUserId(),
        user.getUserName(),
        user.getCity(),
        user.getAge(),
      }
    );
    return update;
  }
}
