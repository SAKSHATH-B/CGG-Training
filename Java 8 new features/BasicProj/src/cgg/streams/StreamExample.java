package cgg.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

  public static void main(String[] args) {
    String[] arr = { "AA", "BB", "CC" };
    Stream<String> stream = Arrays.stream(arr);
    stream.forEach(System.out::println);

    Stream<String> of = Stream.of("A", "B", "C", "D");

    System.out.println("--------------------------");
    of.forEach(System.out::println);

    List<String> list = new ArrayList<>();
    list.add("PQR");
    list.add("XYZ");
    list.add("ABC");

    Stream<String> stream2 = list.stream();
    System.out.println("------------------------");
    stream2.forEach(System.out::println);

    List<Student> stuList = new ArrayList<>();
    stuList.add(new Student("PK", 23));
    stuList.add(new Student("KK", 26));
    stuList.add(new Student("MK", 23));
    stuList.add(new Student("SK", 21));
    stuList.add(new Student("RK", 20));
    stuList.add(new Student("BK", 30));

    Stream<Student> parallelStream = stuList.parallelStream();
    System.out.println("Student data send for processing:::");
    parallelStream.forEach(s -> doProcess(s));

    System.out.println("-----------------------------");
    Stream<String> build = Stream
      .<String>builder()
      .add("kk")
      .add("Pk")
      .add("MK")
      .build();
    build.forEach(System.out::println);

    System.out.println("----------------------------");
    Stream<String> limit = Stream.generate(() -> "Hello").limit(10);
    limit.forEach(System.out::println);

    System.out.println("---------------------------");
    Stream<Integer> limit2 = Stream.iterate(10, i -> i + 2).limit(10);
    limit2.forEach(System.out::println);

    System.out.println("----------------------");
    IntStream range = IntStream.range(1, 6);
    range.forEach(System.out::println);

    System.out.println("----------------------");
    IntStream range2 = IntStream.rangeClosed(1, 6);
    range2.forEach(System.out::println);

    System.out.println("--------------------------------");
    Random random = new Random();
    DoubleStream doubles = random.doubles(5);
    doubles.forEach(System.out::println);

    System.out.println("-----------------------------");
    IntStream chars = "abcd".chars();
    chars.forEach(System.out::println);
  }

  private static void doProcess(Student s) {
    System.out.println(s);
  }
  //massive amount of data for processing going for parallelStream is a good option
  //order of iteration of elemnets is not maintained
  //makes use of multithreads as well multi core processor

}
