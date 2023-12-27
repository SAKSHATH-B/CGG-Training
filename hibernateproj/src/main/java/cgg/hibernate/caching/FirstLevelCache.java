package cgg.hibernate.caching;

import cgg.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCache {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();
    Session session = sessionFactory.openSession();

    Student student = session.get(Student.class, 1);
    System.out.println(student);

    Student student2 = session.get(Student.class, 1);
    System.out.println(student2);

    System.out.println(session.contains(student));
    session.close();
    sessionFactory.close();
  }
}
