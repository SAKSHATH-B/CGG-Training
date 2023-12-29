package com.cgg.criteriaAPI.criteriabuilderparameter;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaParameterExpression;
import org.hibernate.query.criteria.JpaRoot;

public class Test {

  public static void main(String[] args) {
    String nickName = "Sam";
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Person> criteria = builder.createQuery(Person.class);
      JpaRoot<Person> root = criteria.from(Person.class);

      JpaParameterExpression<String> nickNameParameter = builder.parameter(
        String.class
      );
      criteria.where(builder.equal(root.get("nickName"), nickNameParameter));

      Query<Person> query = session.createQuery(criteria);
      query.setParameter(nickNameParameter, nickName);

      List<Person> resultList = query.getResultList();
      for (Person person : resultList) {
        System.out.println(person);
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }
}
