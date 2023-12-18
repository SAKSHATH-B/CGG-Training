package cgg.functionalinterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class BinaryOperatorDefaultMeth {

  public static void main(String[] args) {
    List<Employee> empList = new ArrayList<>();
    empList.add(new Employee("A", 30000.00, "HR"));
    empList.add(new Employee("B", 20000.00, "HR"));
    empList.add(new Employee("C", 100000.00, "HR"));
    empList.add(new Employee("D", 30000.00, "HR"));

    empList.add(new Employee("X", 30000.00, "Finance"));
    empList.add(new Employee("Y", 20000.00, "Finance"));
    empList.add(new Employee("X", 1000.00, "Finance"));
    empList.add(new Employee("P", 90000.00, "Finance"));

    Comparator<Employee> salaryComparator = Comparator.comparing(
      Employee::getSalary
    );

    Map<String, Optional<Employee>> maxSalByDeptMap = empList
      .stream()
      .collect(
        Collectors.groupingBy(
          Employee::getDeptName,
          Collectors.reducing(BinaryOperator.maxBy(salaryComparator))
        )
      );
    System.out.println("Employee max salary by department wise:");
    maxSalByDeptMap.forEach((deptName, emp) -> {
      System.out.println(deptName);
      Employee employee = emp.get();
      System.out.println(employee);
    });

    System.out.println();

    Map<String, Optional<Employee>> minSalByDeptMap = empList
      .stream()
      .collect(
        Collectors.groupingBy(
          Employee::getDeptName,
          Collectors.reducing(BinaryOperator.minBy(salaryComparator))
        )
      );
    System.out.println("Employee min salary by department wise:");
    minSalByDeptMap.forEach((deptName, emp) -> {
      System.out.println(deptName);
      Employee employee = emp.get();
      System.out.println(employee);
    });
  }
}
