package com.cgg.Interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveDataCT {

  private static final Logger logger = LogManager.getLogger(SaveDataCT.class);

  public static void main(String[] args) {
    Transaction tx = null;
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      tx = session.beginTransaction();

      Person person1 = new Person();
      person1.setPersonName("Sakshath B");
      person1.setUsername("sakb");
      person1.setPassword("passs#123");
      person1.setAccessLevel(1);

      Person person2 = new Person();
      person2.setPersonName("Barry Johnson");
      person2.setUsername("barryj");
      person2.setPassword("barry#123");
      person2.setAccessLevel(1);

      session.persist(person1);
      session.persist(person2);

      logger.info("Person records saved successfully...");

      tx.commit();
    } catch (Exception e) {
      logger.error("Failed to save person records " + e);
    }
  }
}
