package com.stackroute.keepnote.repository;

import com.stackroute.keepnote.model.Note;
import java.util.List;

public interface NoteDao {
  public void addNote(Note note);

  public Boolean deleteNote(int noteId);

  public List<Note> getAllNotes();

  public Boolean exists(int noteId);
}
