package cgg.spring.jdbc.jdbcclient.dao;

import cgg.spring.jdbc.jdbcclient.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {

  private JdbcClient jdbcClient;

  //   public JdbcClient getJdbcClient() {
  //     return jdbcClient;
  //   }

  //   public void setJdbcClient(JdbcClient jdbcClient) {
  //     this.jdbcClient = jdbcClient;
  //   }

  public UserDaoImpl(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  @Override
  public User createUser(User user) {
    jdbcClient
      .sql("insert into user1 values(?,?,?)")
      .param(1, user.getId())
      .param(2, user.getName())
      .param(3, user.getAbout())
      .update();
    return user;
  }

  @Override
  public User updateUser(User user) {
    jdbcClient
      .sql("update user1 set name=:name, about=:about where id=:id")
      .param("name", user.getName())
      .param("about", user.getAbout())
      .param("id", user.getId())
      .update();
    return user;
  }

  @Override
  public int deleteUser(int id) {
    int update = jdbcClient
      .sql("delete from user1 where id=:id")
      .param("id", id)
      .update();
    return update;
  }

  @Override
  public User getUserById(int id) {
    User user = jdbcClient
      .sql("select * from user1 where id=:id")
      .param("id", id)
      .query(User.class)
      .single();
    return user;
  }

  @Override
  public List<User> getAllUsers() {
    return jdbcClient.sql("select * from user1").query(User.class).list();
  }
}
