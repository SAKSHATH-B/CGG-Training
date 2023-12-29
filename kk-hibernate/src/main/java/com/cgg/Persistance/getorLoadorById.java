package com.cgg.Persistance;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class getorLoadorById {

  public static void main(String[] args) {
    // getPersonbyId();
    // loadPersonbyId();
    // personbyId();
    // personbyIdloadOptional();
    // loadBookBySimpleNaturalId();
    // loadBookByNaturalId();
    loadBookByOptionalNaturalId();
  }

  private static void loadBookByOptionalNaturalId() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      String naturalId = "978-9730228236";
      Optional<Book> optional = session
        .byNaturalId(Book.class)
        .using("isbn", naturalId)
        .loadOptional();
      if (optional.isPresent()) {
        Book book = optional.get();
        System.out.println(book.getTitle() + "\t" + book.getAuthor().getName());
      } else {
        System.out.println("No Info");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void loadBookByNaturalId() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      String naturalId = "978-9730228236";
      Book book = session
        .byNaturalId(Book.class)
        .using("isbn", naturalId)
        .load();
      if (book != null) {
        System.out.println(book.getTitle() + "\t" + book.getAuthor().getName());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void loadBookBySimpleNaturalId() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      String naturalId = "978-9730228236";
      Book book = session.bySimpleNaturalId(Book.class).getReference(naturalId);
      if (book != null) {
        System.out.println(book.getTitle() + "\t" + book.getAuthor().getName());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void personbyIdloadOptional() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      long personId = 1l;
      Optional<Person> optional = session
        .byId(Person.class)
        .loadOptional(personId);

      if (optional.isPresent()) {
        Person person = optional.get();
        System.out.println(person.getId() + "\t" + person.getName());
      } else {
        System.out.println("Person doesn't exist");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void personbyId() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      long personId = 1l;
      Person person = session.byId(Person.class).load(personId);

      if (person != null) {
        System.out.println(person.getId() + "\t" + person.getName());
      } else {
        System.out.println("Person doesn't exist");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void loadPersonbyId() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      long personId = 1l;
      Person person = session.getReference(Person.class, personId);
      if (person != null) {
        System.out.println(person.getId() + "\t" + person.getName());
      } else {
        System.out.println("Person doesn't exist");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void getPersonbyId() {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      long personId = 1l;
      Person person = session.get(Person.class, personId);
      if (person != null) {
        System.out.println(person.getId() + "\t" + person.getName());
      } else {
        System.out.println("Person doesn't exist");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
