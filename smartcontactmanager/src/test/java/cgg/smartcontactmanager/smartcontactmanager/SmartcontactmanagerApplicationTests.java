package cgg.smartcontactmanager.smartcontactmanager;

import cgg.smartcontactmanager.smartcontactmanager.dao.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmartcontactmanagerApplicationTests {

  @Autowired
  private UserRepository userRepository;

  @Test
  void contextLoads() {}

  @Test
  void repoTest() {
    System.out.println(
      userRepository.getClass().getName() +
      "-----" +
      userRepository.getClass().getPackageName()
    );
  }
}
