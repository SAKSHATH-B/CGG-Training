package cgg.hibernate.map;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();

    //creating questions
    Question q1 = new Question();
    q1.setQuestionId(1212);
    q1.setQuestion("What is Java?");

    Question q2 = new Question();
    q2.setQuestionId(242);
    q2.setQuestion("What is Collection Framework?");

    //creating Answers
    Answer a1 = new Answer();
    a1.setAnswerId(343);
    a1.setAnswer("Java is a programming language.");

    Answer a2 = new Answer();
    a2.setAnswerId(3431);
    a2.setAnswer("Java is used to create software");

    Answer a3 = new Answer();
    a3.setAnswerId(125);
    a3.setAnswer("Api to create group of objects");

    Answer a4 = new Answer();
    a4.setAnswerId(1251);
    a4.setAnswer("More efficient to work with collections framework");

    a1.setQuestion(q1);
    a2.setQuestion(q1);

    a3.setQuestion(q2);
    a4.setQuestion(q2);

    Session session = sessionFactory.openSession();
    // session.beginTransaction();

    //saving
    // session.persist(q1);
    // session.persist(q2);
    // session.persist(a1);
    // session.persist(a2);
    // session.persist(a3);
    // session.persist(a4);

    // session.getTransaction().commit();

    //fetching...
    // Question question = session.get(Question.class, 1212);
    // System.out.println(question);
    // String answer = question.getAnswer().getAnswer();
    // System.out.println(answer);

    Question question = session.get(Question.class, 1212);
    System.out.println(question);
    List<Answer> answers = question.getAnswers();
    for (Answer answer : answers) {
      System.out.println(answer);
    }

    session.close();
    sessionFactory.close();
  }
}
