package com.cgg.criteriaAPI.joinquery;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class JoinQueryTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      CriteriaBuilder builder = session.getCriteriaBuilder();

      CriteriaQuery<Phone> criteriaQuery = builder.createQuery(Phone.class);
      Root<Phone> root = criteriaQuery.from(Phone.class);
      //   root.join("person");   --  lazy fetch
      root.fetch("person"); //--eager fetch
      root.fetch("calls"); //--eager fetch

      criteriaQuery.where(builder.isNotEmpty(root.get("calls")));

      Query<Phone> query = session.createQuery(criteriaQuery);

      List<Phone> resultList = query.getResultList();
      for (Phone phone : resultList) {
        System.out.println("Phone Details::::::::::::::::::");
        System.out.println(
          phone.getId() +
          "\t" +
          phone.getNumber() +
          "\t" +
          phone.getType().toString()
        );
        System.out.println("Person Details::::::::::::");
        Person person = phone.getPerson();
        System.out.println(
          person.getId() +
          "\t" +
          person.getName() +
          "\t" +
          person.getName() +
          "\t" +
          person.getCreatedOn() +
          "\t" +
          person.getAddress() +
          "\t" +
          person.getVersion()
        );
        List<Call> calls = phone.getCalls();
        System.out.println("Phone call details::::::::::");
        for (Call call : calls) {
          System.out.println(
            call.getId() +
            "\t" +
            call.getDuration() +
            "\t" +
            call.getTimestamp()
          );
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
