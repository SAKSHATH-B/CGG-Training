package reducecollect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceAndCollectEx {

  public static void main(String[] args) {
    List<Integer> integers = new ArrayList<>();
    integers.add(10);
    integers.add(20);
    integers.add(30);

    Integer sum = integers.stream().reduce(100, (x, y) -> x + y);
    System.out.println(sum);

    System.out.println("_______________________________");

    List<String> names = new ArrayList<>();
    names.add("abc");
    names.add("def");
    names.add("ghi");
    // List<String> collect = names
    //   .stream()
    //   .map(e -> e.toUpperCase())
    //   .collect(Collectors.toList());
    List<String> collect = names
      .stream()
      .map(String::toUpperCase)
      .collect(Collectors.toList());
    collect.forEach(System.out::println);
  }
}
