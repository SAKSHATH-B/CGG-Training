package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

  public static void main(String[] args) {
    // String[] arr = { "a", "b", "c" };
    // Stream<String> stream = Arrays.stream(arr);
    // stream.forEach(System.out::println);

    // System.out.println("___________________________");
    // Stream<String> of = Stream.of("d", "e", "f");
    // of.forEach(System.out::println);

    // System.out.println("___________________________");
    // List<String> lst = new ArrayList<>();
    // lst.add("PQR");
    // lst.add("xyz");
    // lst.add("abc");

    // Stream<String> stream2 = lst.stream();
    // System.out.println("------------------------");
    // stream2.forEach(System.out::println);

    System.out.println("------------------------");
    List<Student> studList = new ArrayList<>();
    studList.add(new Student("react", 22));
    studList.add(new Student("hello", 22));
    studList.add(new Student("das", 22));
    studList.add(new Student("das", 22));
    studList.add(new Student("das", 22));
    studList.add(new Student("das", 22));
    studList.add(new Student("das", 22));
    studList.add(new Student("das", 22));
    studList.add(new Student("das", 22));
    studList.add(new Student("ieugd", 22));

    Stream<Student> parallelStream = studList.parallelStream();
    System.out.println("Student data send for processing:::");
    // parallelStream.forEach(s -> doProcess(s));
    parallelStream.forEach(System.out::println);

    IntStream chars = "abcd".chars();
    System.out.println("-------------------------------------------");
    chars.forEach(System.out::println);

    System.out.println("-------------------------------------------");
    // Stream<String> splitAsStream = Pattern.compile(",");
    // compile.splitAsStream("a,b,c");
  }

  private static void doProcess(Student s) {
    System.out.println(s);
  }
}
