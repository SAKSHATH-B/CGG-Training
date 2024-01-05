package com.cgg.EnversAuditing;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

public class ReadingEntityAuditInfoTest {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      long customerId = 1L;
      AuditReader auditReader = AuditReaderFactory.get(session);
      List<Number> revisions = AuditReaderFactory
        .get(session)
        .getRevisions(Customer.class, customerId);
      for (Number number : revisions) {
        Customer customer = auditReader.find(
          Customer.class,
          customerId,
          number
        );
        System.out.println("Revision no : " + number);
        System.out.println(customer);
      }
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }
}
