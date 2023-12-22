package cgg.hibernate.map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Answer {

  @Id
  @Column(name = "answer_id")
  private int answerId;

  private String answer;

  // @OneToOne(mappedBy = "answer")
  // private Question question;

  @ManyToOne
  @JoinColumn(name = "q_id")
  private Question question;

  public Answer(int answerId, String answer) {
    this.answerId = answerId;
    this.answer = answer;
  }

  public Answer(int answerId, String answer, Question question) {
    this.answerId = answerId;
    this.answer = answer;
    this.question = question;
  }

  public Answer() {}

  public int getAnswerId() {
    return answerId;
  }

  public void setAnswerId(int answerId) {
    this.answerId = answerId;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  @Override
  public String toString() {
    return answer;
  }
}
