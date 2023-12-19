package cgg.hibernate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

  public static void main(String[] args) {
    SessionFactory factory = new Configuration()
      .configure()
      .buildSessionFactory();

    Session session = factory.openSession();

    // Student s = session.get(Student.class, 101);
    // Student s = session.load(Student.class, 104);
    // Student s = session.getReference(Student.class, 101);
    // System.out.println(s);

    // Address a = session.get(Address.class, 1);
    // System.out.println(a);
    // Address a1 = session.get(Address.class, 1);
    // System.out.println(a1);

    //fetch Image
    Address ad = session.get(Address.class, 1);
    byte[] image = ad.getImage();
    try {
      FileOutputStream fos = new FileOutputStream("src/main/java/fetchimg.jpg");
      fos.write(image);
      fos.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    session.close();
  }
}
