package cgg.functionalinterface.FunctionDefaultMeth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionComposeEx {

  public static void main(String[] args) {
    Function<Employee, String> empNameFun = Employee::getName;

    Function<Employee, Employee> empFirstNameFun = e -> {
      int index = e.getName().indexOf(" ");
      String firstName = e.getName().substring(0, index);
      e.setName(firstName);
      return e;
    };

    List<Employee> employeeList = Arrays.asList(
      new Employee("Tom Jones", 45),
      new Employee("Harry Major", 25),
      new Employee("Ethan Hardy", 65),
      new Employee("Nancy Smith", 15),
      new Employee("Deborah Sprightly", 29)
    );

    List<String> empFirstNameList = convertEmpListToNamesList(
      employeeList,
      empNameFun.compose(empFirstNameFun)
    );
    empFirstNameList.forEach(System.out::println);
  }

  public static List<String> convertEmpListToNamesList(
    List<Employee> employeeList,
    Function<Employee, String> funcEmpToString
  ) {
    List<String> empNameList = new ArrayList<String>();
    employeeList.forEach(e -> empNameList.add(funcEmpToString.apply(e)));
    // for (Employee emp : employeeList) {
    //   empNameList.add(funcEmpToString.apply(emp));
    // }
    return empNameList;
  }
}
