package com.cgg.nativesql;

import java.math.BigInteger;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class NativeQueryTest {

  public static void main(String[] args) {
    // getPersonInfoV1();
    // getPersonInfoV2();
    // getPersonInfoV3();
    // getPersonEntityV1();
    getPersonEntityV2();
  }

  private static void getPersonEntityV2() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      List<Person> list = session
        .createNativeQuery(
          "select id,name,nickName,address,createdOn,version from person"
        )
        .addEntity(Person.class)
        .list();
      list.forEach(System.out::println);
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }

  private static void getPersonEntityV1() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      List<Person> list = session
        .createNativeQuery("select * from person")
        .addEntity(Person.class)
        .list();
      list.forEach(System.out::println);
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }

  private static void getPersonInfoV3() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      List<Object[]> list = session
        .createNativeQuery("select id,name from Person")
        .addScalar("id")
        .addScalar("name")
        .list();
      for (Object[] objects : list) {
        Long id = (Long) objects[0];
        String name = (String) objects[1];
        System.out.println("Person id: " + id);
        System.out.println("Person name: " + name);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void getPersonInfoV2() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      List<Object[]> list = session
        .createNativeQuery("select id,name from Person")
        .addScalar("id", Long.class)
        .addScalar("name", String.class)
        .list();
      for (Object[] objects : list) {
        Long id = (Long) objects[0];
        String name = (String) objects[1];
        System.out.println("Person id: " + id);
        System.out.println("Person name: " + name);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void getPersonInfoV1() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      List<Object[]> list = session
        .createNativeQuery("select * from Person")
        .list();
      for (Object[] objects : list) {
        Long id = (Long) objects[0];
        String name = (String) objects[3];
        System.out.println("Person id: " + id);
        System.out.println("Person name: " + name);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
