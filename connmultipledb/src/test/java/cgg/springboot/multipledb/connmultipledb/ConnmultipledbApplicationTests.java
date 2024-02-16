package cgg.springboot.multipledb.connmultipledb;

import cgg.springboot.multipledb.connmultipledb.entities.Product;
import cgg.springboot.multipledb.connmultipledb.entities.User;
import cgg.springboot.multipledb.connmultipledb.repo.ProductRepo;
import cgg.springboot.multipledb.connmultipledb.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConnmultipledbApplicationTests {

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private ProductRepo productRepo;

  @Test
  public void dbTest() {
    User user = User
      .builder()
      .firstName("a")
      .lastName("b")
      .email("a@gmail.com")
      .build();
    Product product = Product
      .builder()
      .name("Apple iphone")
      .price(54000)
      .live(true)
      .description("this is apple product")
      .build();
    productRepo.save(product);
    userRepo.save(user);
    System.out.println("data saved");
  }

  @Test
  public void getData() {
    productRepo
      .findAll()
      .forEach(product -> System.out.println(product.getName()));
    userRepo.findAll().forEach(user -> System.out.println(user.getFirstName()));
  }
}
