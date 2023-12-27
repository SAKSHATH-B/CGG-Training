package cgg.hibernate.caching;

import cgg.hibernate.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * SecondLevelCacheEx
 */
public class SecondLevelCacheEx {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();
    Session session1 = sessionFactory.openSession();
    // Student student1 = session1.get(Student.class, 4);
    Query query1 = session1.createQuery("from Student st where st.id = 10");
    query1.setCacheable(true);
    List list1 = query1.list();
    list1.forEach(System.out::println);
    session1.close();

    Session session2 = sessionFactory.openSession();
    // Student student2 = session2.get(Student.class, 4);
    // System.out.println(student2);
    Query query2 = session2.createQuery("from Student st where st.id = 10");
    query2.setCacheable(true);
    List list2 = query2.list();
    list2.forEach(System.out::println);
    session2.close();
    sessionFactory.close();
  }
}
