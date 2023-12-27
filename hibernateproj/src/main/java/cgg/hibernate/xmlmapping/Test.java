package cgg.hibernate.xmlmapping;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Test {

  public static void main(String[] args) {
    Session session = new Configuration()
      .configure()
      .buildSessionFactory()
      .openSession();
    Person person = new Person(123, "Person1", "ParkStreet", "38682");
    session.beginTransaction();
    session.persist(person);
    session.getTransaction().commit();
    session.close();
  }
}
