package mapReduce;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {

  public static List<Employee> getEmployees() {
    List<Employee> list = new ArrayList<>();
    list.add(new Employee(1, "Arjiun", "A", 60000));
    list.add(new Employee(2, "Hemlo", "B", 30000));
    list.add(new Employee(3, "Hello", "A", 80000));
    list.add(new Employee(4, "Rockstar", "A", 90000));
    list.add(new Employee(5, "ramu", "C", 15000));
    return list;
  }
}
