package cgg.springmvc.dao;

import cgg.springmvc.entities.Todo;
import jakarta.transaction.Transactional;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoDao {

  @Autowired
  SessionFactory sessionFactory;

  @Transactional
  public int save(Todo todo) {
    return (Integer) sessionFactory.getCurrentSession().save(todo);
  }

  @Transactional
  public List<Todo> getAll() {
    List<Todo> allTodos = sessionFactory
      .getCurrentSession()
      .createQuery("From Todo", Todo.class)
      .list();
    return allTodos;
  }

  @Transactional
  public void deleteTodo(int id) {
    Todo todo = sessionFactory.getCurrentSession().getReference(Todo.class, id);
    sessionFactory.getCurrentSession().remove(todo);
  }
}
