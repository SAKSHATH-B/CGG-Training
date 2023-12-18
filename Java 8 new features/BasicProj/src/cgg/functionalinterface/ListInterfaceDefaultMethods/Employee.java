package cgg.functionalinterface.ListInterfaceDefaultMethods;

public class Employee {

  private String name;
  private Double salary;
  private String deptName;

  public Employee(String name, Double salary, String deptName) {
    this.name = name;
    this.salary = salary;
    this.deptName = deptName;
  }

  public String getName() {
    return name;
  }

  public Double getSalary() {
    return salary;
  }

  public String getDeptName() {
    return deptName;
  }

  @Override
  public String toString() {
    return (
      "Employee [name=" +
      name +
      ", salary=" +
      salary +
      ", deptName=" +
      deptName +
      "]"
    );
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }
}
