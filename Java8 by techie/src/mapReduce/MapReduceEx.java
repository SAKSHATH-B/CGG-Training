package mapReduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceEx {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(3, 2, 8, 4, 5, 3, 5);
    List<String> words = Arrays.asList("corejava", "spring", "hibernate");

    //mapToInt in stream function
    int sum = numbers.stream().mapToInt(i -> i).sum();
    System.out.println(sum);

    //reduce method
    Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
    System.out.println(reduceSum);

    //reduce and method reference
    Optional<Integer> reduceMR = numbers.stream().reduce(Integer::sum);
    System.out.println(reduceMR.get());

    Optional<String> longestString = words
      .stream()
      .reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2);
    System.out.println(longestString.get());

    double asDouble = EmployeeDB
      .getEmployees()
      .stream()
      .filter(emp -> emp.getGrade().contains("A"))
      .map(i -> i.getSalary())
      .mapToDouble(i -> i)
      .average()
      .getAsDouble();

    double sum2 = EmployeeDB
      .getEmployees()
      .stream()
      .filter(e -> e.getGrade().contains("A"))
      .map(i -> i.getSalary())
      .mapToDouble(i -> i)
      .sum();

    System.out.println(asDouble);
    System.out.println(sum2);
  }
}
