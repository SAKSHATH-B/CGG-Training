package com.cgg.criteriaAPI.criteriaWithMultipleRoot;

import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.Predicate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;

public class Test {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
      JpaCriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class);

      JpaRoot<Person> personRoot = criteria.from(Person.class);
      JpaRoot<Partner> partnerRoot = criteria.from(Partner.class);
      criteria.multiselect(personRoot, partnerRoot);

      JpaPredicate personRestriction = builder.and(
        builder.equal(
          personRoot.get("address"),
          "Bank of Canada,234 Wellington Street"
        ),
        builder.isNotEmpty(personRoot.get("phones"))
      );
      Predicate partnerRestriction = builder.and(
        builder.like(partnerRoot.get("name"), "%Mur%"),
        builder.equal(partnerRoot.get("version"), 1)
      );

      criteria.where(builder.and(personRestriction, partnerRestriction));

      List<Tuple> tuples = session.createQuery(criteria).getResultList();
      for (Tuple tuple : tuples) {
        Person person = (Person) tuple.get(0);
        if (person != null) {
          System.out.println(person);
          List<Phone> phones = person.getPhones();
          for (Phone phone : phones) {
            System.out.println(
              phone.getId() +
              "\t" +
              phone.getNumber() +
              "\t" +
              phone.getType().toString()
            );
          }
        }

        Partner partner = (Partner) tuple.get(1);
        System.out.println(partner);
      }
    }
  }
}
