package parallelStream;

import java.util.List;
import java.util.stream.IntStream;

public class parallelStreamEx {

  public static void main(String[] args) {
    long start = 0;
    long end = 0;

    // start = System.currentTimeMillis();
    // IntStream.range(1, 100).forEach(System.out::println);
    // end = System.currentTimeMillis();
    // System.out.println("Plain Stream took time: " + (end - start));

    // System.out.println("----------------------------------------------");

    // start = System.currentTimeMillis();
    // IntStream.range(1, 100).parallel().forEach(System.out::println);
    // end = System.currentTimeMillis();
    // System.out.println("parallel Stream took time: " + (end - start));

    // IntStream
    //   .range(1, 10)
    //   .forEach(x ->
    //     System.out.println(
    //       "Thread: " + Thread.currentThread().getName() + " : " + x
    //     )
    //   );
    // IntStream
    //   .range(1, 10)
    //   .parallel()
    //   .forEach(x ->
    //     System.out.println(
    //       "Thread: " + Thread.currentThread().getName() + " : " + x
    //     )
    //   );

    List<Employee> employees = EmployeeDB.getEmployees();

    //normal stream
    start = System.currentTimeMillis();
    double salaryWithStream = employees
      .stream()
      .map(Employee::getSalary)
      .mapToDouble(i -> i)
      .average()
      .getAsDouble();
    end = System.currentTimeMillis();
    System.out.println(
      "Normal stream execution time :" +
      (end - start) +
      " : Avg salary :" +
      salaryWithStream
    );

    //parallelstream method
    start = System.currentTimeMillis();
    double salaryWithParalle = employees
      .parallelStream()
      .map(Employee::getSalary)
      .mapToDouble(i -> i)
      .average()
      .getAsDouble();
    end = System.currentTimeMillis();
    System.out.println(
      "parallel stream execution time :" +
      (end - start) +
      " : Avg salary :" +
      salaryWithParalle
    );
  }
}
