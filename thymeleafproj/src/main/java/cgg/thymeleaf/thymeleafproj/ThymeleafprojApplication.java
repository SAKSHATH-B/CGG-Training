package cgg.thymeleaf.thymeleafproj;

import cgg.thymeleaf.thymeleafproj.dao.UserDao;
import cgg.thymeleaf.thymeleafproj.entities.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafprojApplication implements CommandLineRunner {

  @Autowired
  private UserDao userDao;

  public static void main(String[] args) {
    SpringApplication.run(ThymeleafprojApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // userDao.createTable();
    // System.out.println("Table Created...");
    // createUser();
  }
  // public void createUser() throws NumberFormatException, IOException {
  //   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  //   System.out.println("Enter User id : ");
  //   int id = Integer.parseInt(br.readLine());
  //   System.out.println("Enter User Name : ");
  //   String name = br.readLine();
  //   System.out.println("Enter User Age : ");
  //   int age = Integer.parseInt(br.readLine());
  //   System.out.println("Enter User City : ");
  //   String city = br.readLine();

  //   User user = new User();
  //   user.setUserId(id);
  //   user.setUserName(name);
  //   user.setAge(age);
  //   user.setCity(city);

  //   int res = userDao.createUser(user);
  //   System.out.println("User Added Successfully..." + res);
  // }
}
