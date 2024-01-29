package cgg.springboot.SpringBootProj;

import cgg.springboot.SpringBootProj.entities.Department;
import cgg.springboot.SpringBootProj.entities.Employee;
import cgg.springboot.SpringBootProj.entities.Phone;
import jakarta.transaction.Transactional;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootProjApplication implements CommandLineRunner {

  @Autowired
  private SessionFactory sessionFactory;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootProjApplication.class, args);
    System.out.println("Started...");
  }

  public static void implicitInnerJoin(SessionFactory sessionFactory) {
    List<Employee> list1 = sessionFactory
      .getCurrentSession()
      .createQuery("from Employee", Employee.class)
      .list();
    List<Phone> list2 = sessionFactory
      .getCurrentSession()
      .createQuery("from Phone", Phone.class)
      .list();
    List<Department> list3 = sessionFactory
      .getCurrentSession()
      .createQuery("from Department", Department.class)
      .list();
    System.out.println(list1);
    System.out.println(list2);
    System.out.println(list3);
  }

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    implicitInnerJoin(sessionFactory);
  }
}
