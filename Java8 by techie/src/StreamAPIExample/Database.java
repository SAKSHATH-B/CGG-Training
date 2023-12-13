package StreamAPIExample;

import java.util.ArrayList;
import java.util.List;

public class Database {

  public static List<Employee> getEmployees() {
    List<Employee> list = new ArrayList<>();
    list.add(new Employee(1, "Arjiun", "movie", 600000));
    list.add(new Employee(2, "Hemlo", "IT", 900000));
    list.add(new Employee(3, "Hello", "core", 500000));
    list.add(new Employee(4, "Rockstar", "service", 400000));
    list.add(new Employee(5, "ramu", "social", 1200000));
    return list;
  }
}
