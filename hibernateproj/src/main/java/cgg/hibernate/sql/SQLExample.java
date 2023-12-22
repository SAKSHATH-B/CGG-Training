package cgg.hibernate.sql;

import cgg.hibernate.Student;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();
    Session session = sessionFactory.openSession();

    //retrive all fields from a table
    NativeQuery<Student> nativeQuery = session.createNativeQuery(
      "select * from student",
      Student.class
    );

    List<Student> list = nativeQuery.list();
    list.forEach(System.out::println);

    System.out.println("---------------------------------------------");

    //retrive specific fields from a table
    NativeQuery<Object[]> nativeQuery2 = session.createNativeQuery(
      "select id,name,city from student where city=:x",
      Object[].class
    );
    nativeQuery2.setParameter("x", "MNCL");
    List<Object[]> list2 = nativeQuery2.list();
    list2.forEach(o -> System.out.println(Arrays.toString(o)));

    session.close();
    sessionFactory.close();
  }
}
