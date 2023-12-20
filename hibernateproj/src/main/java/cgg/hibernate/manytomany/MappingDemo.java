package cgg.hibernate.manytomany;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();

    //creating employees
    Employee e1 = new Employee();
    e1.setEmpId(12);
    e1.setName("Rahul");

    Employee e2 = new Employee();
    e2.setEmpId(13);
    e2.setName("Amitabh");

    //creating project
    Project p1 = new Project();
    p1.setProjectId(1);
    p1.setProjectName("Quiz app");

    Project p2 = new Project();
    p2.setProjectId(2);
    p2.setProjectName("ChatBot");

    ArrayList<Employee> list1 = new ArrayList<>();
    list1.add(e1);
    list1.add(e2);
    ArrayList<Project> list2 = new ArrayList<>();
    list2.add(p1);
    list2.add(p2);

    e1.setProjects(list2);
    p2.setEmployees(list1);

    Session session = sessionFactory.openSession();
    session.beginTransaction();

    //saving...
    session.persist(e1);
    session.persist(e2);
    session.persist(p1);
    session.persist(p2);

    session.getTransaction().commit();
    session.close();
    sessionFactory.close();
  }
}
