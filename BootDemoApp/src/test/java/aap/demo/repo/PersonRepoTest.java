package aap.demo.repo;

import static org.assertj.core.api.Assertions.assertThat;

import aap.demo.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonRepoTest {

  @Autowired
  private PersonRepo personRepo;

  @Test
  void isPersonExistsById() {
    Person person = new Person(14, "Fathima", "Hyderabad");
    personRepo.save(person);

    Boolean actualResult = personRepo.isPersonExistsById(14);

    assertThat(actualResult).isTrue();
  }
  // @AfterEach
  // void tearDown() {
  // 	personRepo.deleteAll();
  // }

}
