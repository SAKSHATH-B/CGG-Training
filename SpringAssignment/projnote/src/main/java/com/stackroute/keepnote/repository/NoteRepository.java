package com.stackroute.keepnote.repository;

import com.stackroute.keepnote.model.Note;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;

/*
 * This class contains the code for data storage interactions and methods
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */

@Component
public class NoteRepository implements NoteDao {

  /* Declare a variable called "list" to store all the notes. */
  private List<Note> list = new ArrayList<>();

  public NoteRepository() {
    /* Initialize the variable using proper data type */
  }

  /* This method should return all the notes in the list */
  public List<Note> getList() {
    return list;
  }

  /* This method should set the list variable with new list of notes */
  public void setList(List<Note> list) {
    this.list = list;
  }

  /*
   * This method should Note object as argument and add the new note object into
   * list
   */

  public void addNote(Note note) {
    list.add(note);
  }

  /* This method should deleted a specified note from the list */

  public Boolean deleteNote(int noteId) {
    /* Use list iterator to find matching note id and remove it from the list */
    // int initialSize = list.size();
    // list =
    //   list
    //     .stream()
    //     .filter(d -> d.getNoteId() != noteId)
    //     .collect(Collectors.toList());
    // if (list.size() != initialSize) {
    //   return true;
    // }
    // return false;

    Iterator<Note> iterator = list.iterator();
    while (iterator.hasNext()) {
      Note note = iterator.next();
      if (note.getNoteId() == noteId) {
        iterator.remove();
        return true;
      }
    }
    return false;
  }

  /* This method should return the list of notes */

  public List<Note> getAllNotes() {
    return list;
  }

  /*
   * This method should check if the matching note id present in the list or not.
   * Return true if note id exists in the list or return false if note id does not
   * exists in the list
   */

  public Boolean exists(int noteId) {
    Iterator<Note> iterator = list.iterator();
    while (iterator.hasNext()) {
      Note note = iterator.next();
      if (note.getNoteId() == noteId) {
        return true;
      }
    }
    return false;
  }
}
