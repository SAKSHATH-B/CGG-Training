package cgg.springbootjunit.junitproj.FirstTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// @DisplayName(value = "All Test cases for add class")
@DisplayNameGeneration(value = ReplaceUnderscores.class)
@TestMethodOrder(value = OrderAnnotation.class)
public class AddTest {

  @BeforeAll
  static void beforeall() {
    System.out.println("@BeforeAll method executed");
  }

  @AfterAll
  static void afterall() {
    System.out.println("@Afterall method executed");
  }

  @BeforeEach
  void beforeEach() {
    System.out.println("@BeforeEach method executed");
  }

  @AfterEach
  void afterEach() {
    System.out.println("@AfterEach method executed");
  }

  @Test
  @Order(value = 2)
  void add_Test() {
    Add testAdd = new Add();
    int actualRes = testAdd.add(30, 20);
    // assertEquals(50, actualRes);
    assertThat(actualRes, is(equalTo(50)));
    System.out.println("addTest method executed");
  }

  @RepeatedTest(value = 5)
  @Order(value = 1)
  void sample_Test() {
    System.out.println("Sample Test Execution lets check the order");
  }
}
