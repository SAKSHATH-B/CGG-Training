package cgg.hibernate.namedQueries;

import cgg.hibernate.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class NamedQueriesEx {

  public static void main(String[] args) {
    Session session = new Configuration()
      .configure()
      .buildSessionFactory()
      .openSession();
    session.beginTransaction();
    Query<Student> query = session.createNamedQuery(
      "Student.byName",
      Student.class
    );
    query.setParameter("y", "ninthUser");
    List<Student> list = (List<Student>) query.list();
    session.getTransaction().commit();
    session.close();

    for (Student student : list) {
      System.out.println(student);
    }
  }
}
