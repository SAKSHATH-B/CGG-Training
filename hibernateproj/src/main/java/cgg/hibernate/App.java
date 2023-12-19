package cgg.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    System.out.println("Program Started");
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();
    // System.out.println(sessionFactory);
    // System.out.println(sessionFactory.isClosed());

    //create a student object
    Student s = new Student();
    s.setId(104);
    s.setName("Arvind");
    s.setCity("Mncl");

    //create Address object
    Address ad = new Address();
    ad.setStreet("street1");
    ad.setCity("HYD");
    ad.setOpen(true);
    ad.setAddedDate(new Date());
    ad.setX(5.0);
    try {
      FileInputStream fis = new FileInputStream(
        "src\\main\\java\\cgg\\hibernate\\hello.jpg"
      );
      byte[] data = new byte[fis.available()];
      fis.read(data);
      ad.setImage(data);
    } catch (Exception e) {
      e.printStackTrace();
    }

    //open a session
    Session session = sessionFactory.openSession();

    Transaction tx = session.beginTransaction();
    session.persist(s);
    session.persist(ad);
    tx.commit();

    //close the session at last
    session.close();

    System.out.println("Done...");
  }
}
