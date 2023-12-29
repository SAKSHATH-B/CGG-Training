package com.cgg.Persistance;

import com.cgg.connection;
import java.sql.Statement;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class RefreshEntity {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Person person = session.byId(Person.class).load(1);

      session.doWork(connection -> {
        try (Statement statement = connection.createStatement()) {
          statement.executeUpdate("update person set name=LOWER(name)");
        } catch (Exception e) {
          // TODO: handle exception
          e.printStackTrace();
        }
      });
      session.refresh(person);
      System.out.println(person.getName());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
