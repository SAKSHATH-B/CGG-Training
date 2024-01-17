package cgg.spring.jdbc.jdbcclient;

import cgg.spring.jdbc.jdbcclient.config.JdbcClientConfig;
import cgg.spring.jdbc.jdbcclient.dao.UserDao;
import cgg.spring.jdbc.jdbcclient.entities.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcClientDemo {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(
      JdbcClientConfig.class
    );

    UserDao userDao = context.getBean("userDao", UserDao.class);

    //INSERT
    // User user = new User();
    // user.setId(4);
    // user.setName("Kurup");
    // user.setAbout("I am Kurup Machendra I am a drug dealer");

    // userDao.createUser(user);
    // System.out.println("User Added...");

    //UPDATE
    // User user = new User();
    // user.setId(4);
    // user.setName("Ramana");
    // user.setAbout("Gunturu bullodu...");
    // userDao.updateUser(user);
    // System.out.println("User Updated...");

    //DELETE
    // int deleteUser = userDao.deleteUser(4);
    // System.out.println(deleteUser + " user deleted...");

    //FETCH USER BY ID
    // User userById = userDao.getUserById(3);
    // System.out.println(userById);

    //FETCH ALL USERS
    List<User> users = userDao.getAllUsers();
    users.forEach(System.out::println);
  }
}
