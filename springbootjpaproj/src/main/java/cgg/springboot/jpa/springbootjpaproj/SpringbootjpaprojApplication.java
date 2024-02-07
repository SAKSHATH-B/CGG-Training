package cgg.springboot.jpa.springbootjpaproj;

import cgg.springboot.jpa.springbootjpaproj.dao.UserRepository;
import cgg.springboot.jpa.springbootjpaproj.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootjpaprojApplication {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(
      SpringbootjpaprojApplication.class,
      args
    );
    UserRepository bean = context.getBean(UserRepository.class);

    //create a user
    // User user = new User();
    // user.setName("sakshath");
    // user.setCity("Hyd");
    // user.setStatus("Developer");

    // User user1 = new User();
    // user1.setName("Ajay");
    // user1.setCity("Kukatpally");
    // user1.setStatus("Cloud");

    // User user2 = new User();
    // user2.setName("Madhav");
    // user2.setCity("Mancherial");
    // user2.setStatus("Rich");

    // User user3 = new User();
    // user3.setName("Arvind");
    // user3.setCity("Chennai");
    // user3.setStatus("Java");

    //saving single users
    // User savedUser2 = bean.save(user1);

    //saving multiple users
    // List<User> users = List.of(user, user1, user2, user3);
    // Iterable<User> saveAllUsers = bean.saveAll(users);

    // saveAllUsers.forEach(System.out::println);

    System.out.println("done...");

    System.out.println("===========================================");

    //updating user
    // Optional<User> userById = bean.findById(2);
    // User user = userById.get();
    // user.setName("Madhav");
    // user.setCity("Mancherial");
    // user.setStatus("Rich");

    // User updateUser = bean.save(user);
    // System.out.println("Updated User: " + updateUser);

    System.out.println("===========================================");

    //retrieval of data
    //findById(id) returns an optional containing data
    //findAll()

    // Iterable<User> allUsers = bean.findAll();
    // allUsers.forEach(System.out::println);
    // System.out.println("done...");

    System.out.println("===============================================");
    //deleting the users
    // deleteById(id) - deletes a record with that id if it exists
    //deleteAll(Iterable)

    // bean.deleteById(1);
    // System.out.println("User deleted...");

    // bean.deleteAll(allUsers);
    // System.out.println("All users deleted...");

    //retrieve using custom column
    // List<User> byName = bean.findByName("Madhav");
    // byName.forEach(System.out::println);

    // List<User> byNameAndCity = bean.findByNameAndCity("Ajay", "Kukatpally");
    // byNameAndCity.forEach(System.out::println);

    // List<User> getAllUsers = bean.getAllUsers();
    // getAllUsers.forEach(System.out::println);

    System.out.println("===========================================");

    // List<User> usersByName = bean.getUsersByName("Ajay");
    // usersByName.forEach(System.out::println);

    System.out.println("===========================================");

    // List<User> usersByNameAndCity = bean.getUsersByNameAndCity(
    //   "Arvind",
    //   "Chennai"
    // );
    // usersByNameAndCity.forEach(System.out::println);

    System.out.println("===========================================");

    // List<User> users = bean.getUsers();
    // users.forEach(System.out::println);

    System.out.println("===========================================");

    // List<User> byStatusContaining = bean.findByStatusContaining("hamali");
    // byStatusContaining.forEach(System.out::println);

    System.out.println("===========================================");

    List<User> byStatusLike = bean.findByStatusLike("%Tech%");
    byStatusLike.forEach(System.out::println);
  }
}
