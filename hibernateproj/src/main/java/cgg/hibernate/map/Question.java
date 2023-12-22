package cgg.hibernate.map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

@Entity
public class Question {

  @Id
  @Column(name = "question_id")
  private int questionId;

  private String question;

  //   @OneToOne
  //   @JoinColumn(name = "a_id")
  //   private Answer answer;
  @OneToMany(
    mappedBy = "question",
    fetch = FetchType.EAGER,
    cascade = CascadeType.ALL
  )
  private List<Answer> answers;

  public Question(int questionId, String question, List<Answer> answers) {
    this.questionId = questionId;
    this.question = question;
    this.answers = answers;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

  public Question() {}

  public int getQuestionId() {
    return questionId;
  }

  public void setQuestionId(int questionId) {
    this.questionId = questionId;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  @Override
  public String toString() {
    return question;
  }
}
