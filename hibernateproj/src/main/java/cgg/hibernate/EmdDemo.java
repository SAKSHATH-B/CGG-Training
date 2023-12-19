package cgg.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmdDemo {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();

    //create a object for certificate and student class
    Certificate certi = new Certificate();
    certi.setCourse("Java");
    certi.setDuration("2 Months");

    Student student1 = new Student();
    student1.setId(102);
    student1.setName("Madhav");
    student1.setCity("Mncl");
    student1.setCerti(certi);

    Certificate certi1 = new Certificate();
    certi.setCourse("ANDROID");
    certi.setDuration("3 Months");

    Student student2 = new Student();
    student2.setId(105);
    student2.setName("Sakshath");
    student2.setCity("Hyd");
    student2.setCerti(certi1);

    Session session = sessionFactory.openSession();

    session.beginTransaction();

    session.persist(student1);
    session.persist(student2);

    session.getTransaction().commit();
    session.close();
    sessionFactory.close();
  }
}
