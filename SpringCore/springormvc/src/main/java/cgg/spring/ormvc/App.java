package cgg.spring.ormvc;

import cgg.spring.ormvc.config.HibernateConfig;
import cgg.spring.ormvc.dao.UserDao;
import cgg.spring.ormvc.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(
      HibernateConfig.class
    );
    UserDao userDao = context.getBean("userDao", UserDao.class);

    //CREATE NEW USER
    User user = new User();
    user.setUserId(1);
    user.setUserName("chintu");
    user.setAbout("chintu lives in hyderabad and works in gachibowli.");
    userDao.createUser(user);
    System.out.println("Done User added...");
  }
}
