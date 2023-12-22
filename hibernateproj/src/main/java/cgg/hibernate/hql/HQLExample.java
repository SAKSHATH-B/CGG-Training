package cgg.hibernate.hql;

import cgg.hibernate.Student;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLExample {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();

    Session session = sessionFactory.openSession();

    //HQL syntax
    // using alias as s
    String query = "from Student as s where s.city= :x and s.name= :y ";
    Query q = session.createQuery(query);
    q.setParameter("x", "MNCL");
    q.setParameter("y", "secondUser");

    //two types of results
    //single result -   use uniqueResult()
    //multiple result   -   use List()
    List<Student> list = q.list();
    for (Student s : list) {
      System.out.println(
        s.getName() + " : " + s.getCerti().getCourse() + " : " + s.getCity()
      );
    }

    System.out.println("-------------------------------------------------");

    //transaction is needed for dml
    session.beginTransaction();

    //delete
    // Query q2 = session.createQuery(
    //   "delete from student s s.city= :a and s.name= :b "
    // );
    // q2.setParameter("a", "KRMR");
    // q2.setParameter("b", "fourthUser");
    // int res = q2.executeUpdate();
    // System.out.println("Deleted : " + res);

    //update
    // Query query3 = session.createQuery(
    //   "update Student s set s.city=:c where s.name=:d"
    // );
    // query3.setParameter("c", "DELHI");
    // query3.setParameter("d", "fourthUser");
    // int res1 = query3.executeUpdate();
    // System.out.println(res1 + " objects updated...");

    //executing join query
    Query<Object[]> query4 = session.createQuery(
      "select q.question,q.questionId,a.answer from Question q INNER JOIN q.answers as a",
      Object[].class
    );
    List<Object[]> resultList = query4.getResultList();
    for (Object[] objects : resultList) {
      System.out.println(Arrays.toString(objects));
    }

    session.getTransaction().commit();
    session.close();
    sessionFactory.close();
  }
}
