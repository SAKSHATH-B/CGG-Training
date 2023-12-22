package cgg.hibernate.CascadeTypes;

import cgg.hibernate.map.Answer;
import cgg.hibernate.map.Question;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class CascadeEx {

  public static void main(String[] args) {
    Session session = new Configuration()
      .configure()
      .buildSessionFactory()
      .openSession();

    Question q = new Question();
    q.setQuestionId(12122);
    q.setQuestion("Where is JNTU College Hyd located?");

    Answer a1 = new Answer(
      121,
      "Jntu college Hyd is located near kukatpally.",
      q
    );
    Answer a2 = new Answer(122, "Jntu college Hyd is west side of Hyd.", q);
    Answer a3 = new Answer(
      123,
      "Jntu college Hyd is Opposite to Manjeera Majestic mall.",
      q
    );

    ArrayList<Answer> answers = new ArrayList<>();
    answers.add(a1);
    answers.add(a2);
    answers.add(a3);

    q.setAnswers(answers);

    session.beginTransaction();

    session.persist(q);
    // session.persist(a1);
    // session.persist(a2);
    // session.persist(a3);

    session.getTransaction().commit();
    session.close();
  }
}
