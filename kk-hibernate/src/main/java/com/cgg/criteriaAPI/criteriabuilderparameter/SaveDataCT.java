package com.cgg.criteriaAPI.criteriabuilderparameter;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SaveDataCT {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      session.beginTransaction();

      Person person1 = new Person();
      person1.setName("Mark Bingel");
      person1.setNickName("Mac");
      person1.setAddress("Alameda Street Los Angeles");
      person1.setCreatedOn(new Date());
      person1.setVersion(1);

      Person person2 = new Person();
      person2.setName("Sean Murphy");
      person2.setNickName("Sam");
      person2.setAddress("Bank of Canada,234 Wellington Street");
      person2.setCreatedOn(new Date());
      person2.setVersion(1);

      session.persist(person1);
      session.persist(person2);

      session.getTransaction().commit();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
