package StreamOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamOperation {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("FFFF");
    list.add("a");
    list.add("b");
    list.add("b");
    list.add("h");
    list.add("l");

    // Stream<String> stream = list.stream();
    // Stream<String> distinct = stream.distinct();
    // long count = distinct.count();
    // System.out.println(count);

    long count = list.stream().distinct().count();
    System.out.println(count);
    //streams cannot be reused

    boolean ans = list.stream().anyMatch(s -> s.contains("F"));
    System.out.println(ans);

    List<Student> lst = new ArrayList<>();
    lst.add(new Student("abc", 22));
    lst.add(new Student("adef", 23));
    lst.add(new Student("aghi", 24));
    lst.add(new Student("ajkl", 27));
    lst.add(new Student("aqwe", 26));

    Stream<Student> filterList = lst.stream().filter(s -> s.getAge() > 25);
    filterList.forEach(System.out::println);

    boolean allMatch = lst.stream().allMatch(s -> s.getName().contains("a"));
    System.out.println(allMatch);

    boolean anyMatch = lst.stream().anyMatch(s -> s.getAge() > 36);
    System.out.println(anyMatch);

    boolean noneMatch = lst.stream().noneMatch(s -> s.getAge() > 55);
    System.out.println(noneMatch);
  }
}
