package cgg.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorReverseMeth {

  public static void main(String[] args) {
    List<Employee> empList = new ArrayList<>();
    empList.add(new Employee("Davis", 30));
    empList.add(new Employee("Martin", 40));
    empList.add(new Employee("Alice", 23));
    empList.add(new Employee("Martin", 25));
    empList.add(new Employee("Barry", 34));
    empList.add(new Employee("Martin", 35));
    empList.add(new Employee("James", 45));

    Comparator<Employee> comp = Comparator.comparing(Employee::getName);
    System.out.println("------------------------------------------------");
    empList.sort(comp);
    empList.forEach(System.out::println);
    System.out.println("------------------------------------------------");
    empList.sort(comp.reversed());
    empList.forEach(System.out::println);
  }
}
