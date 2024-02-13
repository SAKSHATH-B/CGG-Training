package cgg.springbootjunit.junitproj.FirstTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.io.TempDir;

public class TestingFiles {

  @Test
  @Tag(value = "tag1")
  @DisplayName("Hello")
  void testWithTempDir(@TempDir Path tempDir, TestInfo testInfo)
    throws IOException {
    Path numbersPath = tempDir.resolve("numberstest.txt");
    List<String> numberList = Arrays.asList("100", "200", "300");
    Files.write(numbersPath, numberList);

    assertAll(
      () -> assertTrue(Files.exists(numbersPath), "Files should exist.."),
      () -> assertLinesMatch(numberList, Files.readAllLines(numbersPath))
    );

    String displayName = testInfo.getDisplayName();
    System.out.println(displayName);
    assertEquals("Hello", displayName);

    Set<String> tags = testInfo.getTags();
    System.out.println(tags);
    assertTrue(tags.contains("tag1"));
  }
}
