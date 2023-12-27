package com.cgg.nativesql;

import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Test2 {

  public static void main(String[] args) {
    nativeQuerySelectUsingManytoOneAssociation();
  }

  private static void nativeQuerySelectUsingManytoOneAssociation() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      List<Phone> phones = session
        .createNativeQuery(
          "select id,phone_number,phone_type,person_id from  Phone"
        )
        .addEntity(Phone.class)
        .list();
      for (Phone phone : phones) {
        System.out.println("Phone-Details=====================");
        System.out.println("Phone Id: " + phone.getId());
        System.out.println("Phone no: " + phone.getNumber());
        System.out.println("Phone Type: " + phone.getType().toString());
        Person person = phone.getPerson();
        if (person != null) {
          System.out.println("Person-Details========");
          System.out.println("Person Id: " + person.getId());
          System.out.println("Person Name: " + person.getName());
          System.out.println("Person NickName: " + person.getNickName());
          System.out.println("Person address: " + person.getAddress());
          System.out.println("Person createdOn: " + person.getCreatedOn());
          System.out.println("Person Version: " + person.getVersion());
        }
      }
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }
}
