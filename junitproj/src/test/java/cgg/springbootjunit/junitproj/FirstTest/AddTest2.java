package cgg.springbootjunit.junitproj.FirstTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(value = AddTest2.CustomDisplayNameGenerator.class)
// @Disabled("for testing")
public class AddTest2 {

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
  void add_Test() {
    Add testAdd = new Add();
    int actualRes = testAdd.add(30, 20);
    assertEquals(50, actualRes);
    System.out.println("addTest method executed");
  }

  @Test
  void sample_Test() {
    System.out.println("Sample Test Execution lets check the order");
  }

  static class CustomDisplayNameGenerator
    extends DisplayNameGenerator.ReplaceUnderscores {

    @Override
    public String generateDisplayNameForClass(Class<?> testClass) {
      return testClass.getName() + " Test cases!!!!!";
    }

    @Override
    public String generateDisplayNameForMethod(
      Class<?> testClass,
      Method testMethod
    ) {
      String name = testClass.getSimpleName() + " " + testMethod.getName();
      return name.replace("_", "---");
    }

    @Override
    public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
      // TODO Auto-generated method stub
      return super.generateDisplayNameForNestedClass(nestedClass);
    }
  }
}
