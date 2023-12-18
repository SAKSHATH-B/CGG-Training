package cgg.functionalinterface.FunctionDefaultMeth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionAndThenEx {

  public static void main(String[] args) {
    Function<Employee, String> empNameFun = Employee::getName;

    List<Employee> employeeList = Arrays.asList(
      new Employee("Tom Jones", 45),
      new Employee("Harry Major", 25),
      new Employee("Ethan Hardy", 65),
      new Employee("Nancy Smith", 15),
      new Employee("Deborah Sprightly", 29)
    );

    Function<String, String> initialFunction = s -> s.substring(0, 1);

    List<String> empNameListInitialChar = convertEmpListToNamesList(
      employeeList,
      empNameFun.andThen(initialFunction)
    );
    empNameListInitialChar.forEach(s -> {
      System.out.println(s);
    });
  }

  public static List<String> convertEmpListToNamesList(
    List<Employee> employeeList,
    Function<Employee, String> funcEmpToString
  ) {
    List<String> empNameList = new ArrayList<String>();
    for (Employee emp : employeeList) {
      empNameList.add(funcEmpToString.apply(emp));
    }
    return empNameList;
  }
}
