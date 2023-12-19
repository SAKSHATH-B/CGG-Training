package entitiesAndCRUD;

import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Task {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      // createEmployee(session);
      // getEmployeebyId(session);
      // updateEmployee(session);
      deleteEmployeebyId(session);
      //save is also used to save the object into db and return a primary key datatype and store it in a variable and throws an error if already present primary key but most of times we use persist method
      //   Integer id = (Integer) session.save(employee);
      //   System.out.println("Employee created with id::" + id);

      //it will creates a entry in db if primary key not exists and updates the primary key if the value with primary key exists
      //   session.saveOrUpdate(employee);

    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private static void deleteEmployeebyId(Session session) {
    Employee employee = session.get(Employee.class, 2);
    if (employee != null) {
      session.beginTransaction();
      session.delete(employee);
      session.getTransaction().commit();
    } else {
      System.out.println("Employee doesnt exist with provided ID...");
    }
  }

  private static void updateEmployee(Session session) {
    Employee employee = session.get(Employee.class, 2);
    if (employee != null) {
      employee.setSalary(20000);
      session.beginTransaction();
      session.update(employee);
      session.getTransaction().commit();
    } else {
      System.out.println("Employee doesnt exist with provided ID...");
    }
  }

  private static void getEmployeebyId(Session session) {
    Employee employee = session.get(Employee.class, 2);
    if (employee != null) {
      System.out.println(employee);
    } else {
      System.out.println("Employee doesnt exist with provided ID...");
    }
  }

  private static Employee getEmployee() {
    Employee employee = new Employee();
    employee.setEmployeeName("luther king");
    employee.setEmail("lk@gmail.com");
    employee.setSalary(60000.00);
    employee.setDoj(new Date());
    return employee;
  }

  private static void createEmployee(Session session) {
    session.beginTransaction();
    session.persist(getEmployee());
    System.out.println("Created/inserted...");
    session.getTransaction().commit();
  }
}
