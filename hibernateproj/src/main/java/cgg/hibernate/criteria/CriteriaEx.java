package cgg.hibernate.criteria;

import cgg.hibernate.Student;
import cgg.hibernate.xmlmapping.Person;
import java.util.List;
import net.sf.ehcache.search.expression.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

public class CriteriaEx {

  public static void main(String[] args) {
    Session session = new Configuration()
      .configure()
      .buildSessionFactory()
      .openSession();

    HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
    JpaCriteriaQuery<Student> c = cb.createQuery(Student.class);
    JpaRoot<Student> root = c.from(Student.class);
    c.select(root);

    Query<Student> query = session.createQuery(c);
    List<Student> res = query.list();
    res.forEach(System.out::println);
  }
}
