package cgg.hibernate.pagination;

import cgg.hibernate.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class PaginationEx {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();
    Session session = sessionFactory.openSession();

    Query<Student> query = session.createQuery("from Student", Student.class);

    //implementing pagination using hibernate
    query.setFirstResult(4);
    query.setMaxResults(5);

    List<Student> list = query.list();
    list.forEach(System.out::println);

    session.close();
    sessionFactory.close();
  }
}
