package com.stackroute.keepnote.repository;

import com.stackroute.keepnote.model.Note;
import jakarta.transaction.Transactional;
import java.io.Serializable;
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
public class NoteRepository implements NoteDao {

  @Autowired
  SessionFactory sessionFactory;

  @Override
  @Transactional
  public Boolean saveNote(Note note) {
    sessionFactory.getCurrentSession().save(note);
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
  public List<Note> getAllNotes() {
    List<Note> list = sessionFactory
      .getCurrentSession()
      .createQuery("From Note", Note.class)
      .list();
    return list;
  }

  @Override
  @Transactional
  public Note getNoteById(int id) {
    Note note = sessionFactory.getCurrentSession().get(Note.class, id);
    return note;
  }

  @Override
  @Transactional
  public Boolean updateNote(Note note) {
    sessionFactory.getCurrentSession().update(note);
    return true;
  }
  /*
   * This method should Note object as argument and add the new note object into
   * list
   */

  // public void saveNote(Note note) {
  //   list.add(note);
  // }

  /* This method should deleted a specified note from the list */

  // public Boolean deleteNote(int noteId) {
  //   /* Use list iterator to find matching note id and remove it from the list */
  //   // int initialSize = list.size();
  //   // list =
  //   //   list
  //   //     .stream()
  //   //     .filter(d -> d.getNoteId() != noteId)
  //   //     .collect(Collectors.toList());
  //   // if (list.size() != initialSize) {
  //   //   return true;
  //   // }
  //   // return false;

  //   Iterator<Note> iterator = list.iterator();
  //   while (iterator.hasNext()) {
  //     Note note = iterator.next();
  //     if (note.getNoteId() == noteId) {
  //       iterator.remove();
  //       return true;
  //     }
  //   }
  //   return false;
  // }

  /* This method should return the list of notes */

  // public List<Note> getAllNotes() {
  //   return list;
  // }

  /*
   * This method should check if the matching note id present in the list or not.
   * Return true if note id exists in the list or return false if note id does not
   * exists in the list
   */
}
