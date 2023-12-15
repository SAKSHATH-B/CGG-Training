package FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

  public static void main(String[] args) {
    Predicate<Integer> pred = t -> t % 2 == 0;
    System.out.println(pred.test(4));

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    list.stream().filter(pred).forEach(System.out::println);
  }
}
