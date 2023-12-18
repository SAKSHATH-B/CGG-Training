package cgg.functionalinterface.ListInterfaceDefaultMethods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class ListInterfaceDefaultMethEx {

  public static void main(String[] args) {
    List<Employee> empList = new ArrayList<>();

    empList.add(new Employee("Raj", 90000.00, "HR"));
    empList.add(new Employee("Frank", 80000.00, "Finance"));
    empList.add(new Employee("Kishan", 30000.00, "HR"));
    empList.add(new Employee("Sean", 90000.00, "Finance"));
    empList.add(new Employee("Rajesh", 90000.00, "HR"));

    empList.forEach(System.out::println);

    System.out.println("-------------------------------");
    System.out.println("Employee Sorted by salary...");

    empList.sort((e1, e2) -> e1.getSalary() > e2.getSalary() ? 1 : -1);
    empList.forEach(System.out::println);
    System.out.println("-------------------------------");

    empList.replaceAll(e -> {
      if (e.getSalary() > 60000.00) {
        return e;
      } else {
        e.setSalary(e.getSalary() + e.getSalary() * 0.1);
        return e;
      }
    });
    empList.forEach(System.out::println);
  }
}
