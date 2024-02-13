package cgg.springbootjunit.junitproj.FirstTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

public class NestedTestCase1 {

  @BeforeAll
  static void setUp() {
    System.out.println("This is beforeall method -- outer class");
  }

  @AfterAll
  static void tearDown() {
    System.out.println("This is afterAll method -- outer class");
  }

  @Test
  void outerTest1() {}

  @Test
  void outerTest2() {}

  @Nested
  @TestInstance(Lifecycle.PER_CLASS)
  class innerClass {

    @BeforeAll
    static void setUp() {
      System.out.println("This is beforeall method -- inner class");
    }

    @AfterAll
    static void tearDown() {
      System.out.println("This is afterAll method -- inner class");
    }

    @Test
    void innerTest1() {}

    @Test
    void innerTest2() {}

    @Test
    void innerTest3() {}
  }
}
