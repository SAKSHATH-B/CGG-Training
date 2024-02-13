package cgg.springbootjunit.junitproj.FirstTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

public class JunitAssertions {

  @Test
  void assertTrueTest() {
    assertTrue(10 > 6, "10 is greater than 6");
    assertTrue(10 > 6, () -> "10 is greater than 6");
  }

  @Test
  void assertFalseTest() {
    assertFalse(76 > 120, "76 is not greater than 120");
  }

  @Test
  void assertEqualsTest() {
    Add add = new Add();
    int actual = add.add(10, 20);
    assertEquals(30, actual);
  }

  @Test
  void assertNotEqualsTest() {
    assertNotEquals(15, 20, "The result is not 20");
  }

  @Test
  void assertIterableTest() {
    Iterable<String> arrayList = new ArrayList<>(Arrays.asList("a", "b", "c"));
    Iterable<String> linkedList = new LinkedList<>(
      Arrays.asList("a", "b", "c")
    );

    assertIterableEquals(arrayList, linkedList);
  }

  @Test
  void assertTimeoutTest() {
    assertTimeout(Duration.ofMillis(500), () -> Thread.sleep(400));
  }
}
