package cgg.functionalinterface.CollectionInterfaceDefaultMethods;

import java.util.ArrayList;
import java.util.List;

public class ClientTest {

  public static void main(String[] args) {
    List<Employee> empList = new ArrayList<>();
    empList.add(new Employee("Raj", 90000.00, "HR"));
    empList.add(new Employee("Frank", 80000.00, "Finance"));
    empList.add(new Employee("Kishan", 30000.00, "HR"));
    empList.add(new Employee("Sean", 90000.00, "Finance"));
    empList.add(new Employee("Rajesh", 90000.00, "HR"));

    empList.forEach(System.out::println);

    System.out.println(
      "-------------------------------------------------------"
    );

    empList.removeIf(s -> "HR".equalsIgnoreCase(s.getDeptName()));

    empList.forEach(System.out::println);
  }
}
