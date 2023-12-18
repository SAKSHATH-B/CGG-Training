package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sortListDemo {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(8);
    list.add(3);
    list.add(12);
    list.add(4);

    //using traditional methods
    // Collections.sort(list);  --  Ascending
    // Collections.reverse(list);   --  Descending
    // System.out.println(list);

    //using stream
    // list.stream().sorted().forEach(System.out::println); //-- Ascending
    // list
    //   .stream()
    //   .sorted(Comparator.reverseOrder())
    //   .forEach(System.out::println); //--descending

    //using traditional method sorting based on salary
    List<Employee> employees = Database.getEmployees();
    // Collections.sort(employees, new MyComparator());
    Collections.sort(
      employees,
      (o1, o2) -> (int) (o1.getSalary() - o2.getSalary())
    );
    System.out.println(employees);

    //using stream api
    employees
      .stream()
      .sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()))
      .forEach(System.out::println);
    employees
      .stream()
      .sorted(Comparator.comparing(emp -> emp.getSalary()))
      .forEach(System.out::println);
    //using method reference
    employees
      .stream()
      .sorted(Comparator.comparing(Employee::getName))
      .forEach(System.out::println);
  }
}

//we can write this logic using lambda expression
class MyComparator implements Comparator<Employee> {

  @Override
  public int compare(Employee o1, Employee o2) {
    return (int) (o1.getSalary() - o2.getSalary()); //--ascending
    // return (int) (o2.getSalary() - o1.getSalary()); //--descending
  }
}
