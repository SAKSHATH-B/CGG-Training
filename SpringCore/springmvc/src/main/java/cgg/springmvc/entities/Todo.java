package cgg.springmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int todoId;

  private String todoTitle;
  private String todoContent;
  private Date todoDate;

  public Todo(int todoId, String todoTitle, String todoContent, Date todoDate) {
    this.todoId = todoId;
    this.todoTitle = todoTitle;
    this.todoContent = todoContent;
    this.todoDate = todoDate;
  }

  public Todo() {}

  public int getTodoId() {
    return todoId;
  }

  public void setTodoId(int todoId) {
    this.todoId = todoId;
  }

  public String getTodoTitle() {
    return todoTitle;
  }

  public void setTodoTitle(String todoTitle) {
    this.todoTitle = todoTitle;
  }

  public String getTodoContent() {
    return todoContent;
  }

  public void setTodoContent(String todoContent) {
    this.todoContent = todoContent;
  }

  public Date getTodoDate() {
    return todoDate;
  }

  public void setTodoDate(Date todoDate) {
    this.todoDate = todoDate;
  }

  @Override
  public String toString() {
    return (
      "Todo [todoId=" +
      todoId +
      ", todoTitle=" +
      todoTitle +
      ", todoContent=" +
      todoContent +
      ", todoDate=" +
      todoDate +
      "]"
    );
  }
}
