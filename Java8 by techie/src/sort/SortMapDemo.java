package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortMapDemo {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("eight", 8);
    map.put("four", 4);
    map.put("ten", 10);
    map.put("two", 2);

    //using lambda expression sorting based on key string
    // List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
    // Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

    // for (Entry<String, Integer> entry : entries) {
    //   System.out.println(entry.getKey() + " " + entry.getValue());
    // }

    //using streamApi
    // map
    //   .entrySet()
    //   .stream()
    //   .sorted(Map.Entry.comparingByKey())
    //   .forEach(System.out::println);
    // System.out.println("-------------------------");
    // map
    //   .entrySet()
    //   .stream()
    //   .sorted(Map.Entry.comparingByValue())
    //   .forEach(System.out::println);

    Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) ->
      (int) (o1.getSalary() - o2.getSalary())
    );
    employeeMap.put(new Employee(176, "Roshan", "IT", 60000), 60);
    employeeMap.put(new Employee(388, "Bikash", "Civil", 90000), 90);
    employeeMap.put(new Employee(470, "Bimal", "Defence", 50000), 50);
    employeeMap.put(new Employee(624, "Sourav", "Core", 40000), 40);
    employeeMap.put(new Employee(284, "Prakash", "Social", 120000), 120);

    // System.out.println(employeeMap);

    //ascending
    employeeMap
      .entrySet()
      .stream()
      .sorted(
        Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))
      )
      .forEach(System.out::println);
    //descending
    employeeMap
      .entrySet()
      .stream()
      .sorted(
        Map.Entry.comparingByKey(
          Comparator.comparing(Employee::getSalary).reversed()
        )
      )
      .forEach(System.out::println);
    //comparing by value
    employeeMap
      .entrySet()
      .stream()
      .sorted(Map.Entry.comparingByValue((o1, o2) -> o1 - o2))
      .forEach(System.out::println);
  }
}
