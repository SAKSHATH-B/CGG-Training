package com.stackroute.keepnote.dao;

import com.stackroute.keepnote.model.Note;
import jakarta.transaction.Transactional;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * This class contains the code for data storage interactions and methods
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */

@Repository
public class NoteDaoImpl implements NoteDao {

  @Autowired
  SessionFactory sessionFactory;

  @Override
  @Transactional
  public Boolean createNote(Note note) {
    sessionFactory.getCurrentSession().persist(note);
    return true;
  }

  @Override
  @Transactional
  public Boolean deleteNote(int noteId) {
    Note note = sessionFactory.getCurrentSession().get(Note.class, noteId);
    if (note != null) {
      sessionFactory.getCurrentSession().remove(note);
      return true;
    } else {
      return false;
    }
  }

  @Override
  @Transactional
  public List<Note> getAllNotesByUserId() {
    List<Note> list = sessionFactory
      .getCurrentSession()
      .createQuery("From Note", Note.class)
      .list();
    return list;
  }

  @Override
  @Transactional
  public Note getNoteById(int noteId) {
    Note note = sessionFactory.getCurrentSession().get(Note.class, noteId);
    return note;
  }

  @Override
  @Transactional
  public Boolean updateNote(Note note) {
    sessionFactory.getCurrentSession().merge(note);
    return true;
  }
}
