package com.cgg.storedProcedures;

import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Test {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      StoredProcedureQuery storedProcedureQuery = session.createStoredProcedureQuery(
        "countPhones"
      );
      storedProcedureQuery.registerStoredProcedureParameter(
        "personId",
        Long.class,
        ParameterMode.IN
      );
      storedProcedureQuery.registerStoredProcedureParameter(
        "phoneCount",
        Long.class,
        ParameterMode.OUT
      );

      storedProcedureQuery.setParameter("personId", 1);

      storedProcedureQuery.execute();
      Long phoneCount = (Long) storedProcedureQuery.getOutputParameterValue(
        "phoneCount"
      );

      System.out.println("Phone Count : " + phoneCount);
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
