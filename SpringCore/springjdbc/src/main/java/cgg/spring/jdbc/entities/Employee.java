package cgg.spring.jdbc.entities;

public class Employee {

  private int emp_id;
  private String emp_name;
  private String emp_sal;

  public Employee(int emp_id, String emp_name, String emp_sal) {
    this.emp_id = emp_id;
    this.emp_name = emp_name;
    this.emp_sal = emp_sal;
  }

  public Employee() {}

  public int getEmp_id() {
    return emp_id;
  }

  public void setEmp_id(int emp_id) {
    this.emp_id = emp_id;
  }

  public String getEmp_name() {
    return emp_name;
  }

  public void setEmp_name(String emp_name) {
    this.emp_name = emp_name;
  }

  public String getEmp_sal() {
    return emp_sal;
  }

  public void setEmp_sal(String emp_sal) {
    this.emp_sal = emp_sal;
  }

  @Override
  public String toString() {
    return (
      "Employee [emp_id=" +
      emp_id +
      ", emp_name=" +
      emp_name +
      ", emp_sal=" +
      emp_sal +
      "]"
    );
  }
}
