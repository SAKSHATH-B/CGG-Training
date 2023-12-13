package Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodRefDemo {

  public static void main(String[] args) {
    EmployeeService service = new EmployeeService();

    //lambda expression
    EmployeeManager manager = () -> new Employee();
    manager.getEmployee().getEmployeeInfo();
    //using constructor reference
    EmployeeManager manager1 = Employee::new;
    manager1.getEmployee().getEmployeeInfo();

    // service
    //   .loadEmployeesFromDB()
    //   .stream()
    //   .map(Employee::getId)
    //   .map(ArrayList::new);

    //anonymous implementation
    // service
    //   .loadEmployeesFromDB()
    //   .stream()
    //   .forEach(
    //     new Consumer<Employee>() {
    //       @Override
    //       public void accept(Employee employee) {
    //         // TODO Auto-generated method stub
    //         System.out.println(employee);
    //       }
    //     }
    //   );

    //lambda expression
    // System.out.println("---------------------------------------");
    // service.loadEmployeesFromDB().forEach(i -> System.out.println(i));

    //method reference with custom method
    // System.out.println("---------------------------------------");
    // service.loadEmployeesFromDB().forEach(MethodRefDemo::print);

    //method reference with predefined class
    // System.out.println("---------------------------------------");
    // service.loadEmployeesFromDB().forEach(System.out::println);

    //using anonymous implemenation
    // List<EmployeeDo> employeeDOS = service
    //   .loadEmployeesFromDB()
    //   .stream()
    //   .map(
    //     new Function<Employee, EmployeeDo>() {
    //       @Override
    //       public EmployeeDo apply(Employee employee) {
    //         // TODO Auto-generated method stub
    //         EmployeeDo employeeDO = new EmployeeDo();
    //         employeeDO.setId(employee.getId());
    //         employeeDO.setName(employee.getName());
    //         employee.setSalary(employee.getSalary());
    //         return employeeDO;
    //       }
    //     }
    //   )
    //   .collect(Collectors.toList());

    //using lambda implementation
    EmployeeMapper mapper = new EmployeeMapper();
    List<EmployeeDo> employeeDOoS = service
      .loadEmployeesFromDB()
      .stream()
      //   .map(employee -> EmployeeMapper.convert(employee))
      //   .map(EmployeeMapper::convert)    --  using class name if method is static
      .map(mapper::convert) //-- using reference object if class is non-static
      .collect(Collectors.toList());

    //print all the names of employees
    //using lambda expression
    List<String> nameList = service
      .loadEmployeesFromDB()
      .stream()
      .map(e -> e.getName())
      .collect(Collectors.toList());

    //using method reference
    List<String> namesList = service
      .loadEmployeesFromDB()
      .stream()
      .map(Employee::getName) //--getName method is not a static method but it can be accessed using class name because the method getName does not contain any arguments in it so it can be accessed as a static method. If there are any arguments present in it then we cannot access it by class name
      .collect(Collectors.toList());

    System.out.println(namesList);
  }

  public static void print(Employee employee) {
    System.out.println(employee);
  }
  //constructor reference
  //reference : constructor -> new
}
