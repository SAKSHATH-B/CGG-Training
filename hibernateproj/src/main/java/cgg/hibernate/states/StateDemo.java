package cgg.hibernate.states;

import cgg.hibernate.Certificate;
import cgg.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();

    Student student = new Student();
    student.setId(1);
    student.setName("user1");
    student.setCity("HYD");
    student.setCerti(new Certificate("Hibernate", "1 month"));

    //transient state - neither in DB nor in session

    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();

    // session.persist(student);
    //persistant state  -   associated with session object and database, as long it is in persistant we can modify the object fields

    student.setName("firstUser");

    //removed state -   associated with session and not with db
    Student s1 = session.get(Student.class, 1);
    session.remove(s1);

    tx.commit();
    session.close();

    //detached state    -   not associated with session, but in database, so no reflections in database
    student.setName("userFirst");
    System.out.println(student.getName());

    sessionFactory.close();
  }
}
