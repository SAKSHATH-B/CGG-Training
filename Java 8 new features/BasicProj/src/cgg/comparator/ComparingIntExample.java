package cgg.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparingIntExample {

  public static void main(String[] args) {
    List<String> list = Arrays.asList(
      "Carter",
      "James",
      "Davis",
      "Zorra",
      "Barry",
      "Zola"
    );

    Comparator<String> comp = Comparator.comparingInt(String::length);

    Collections.sort(list, comp);
    // list.sort(comp);

    list.forEach(System.out::println);
  }
}
