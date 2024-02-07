package com.stackroute.keepnote.repository;

import com.stackroute.keepnote.model.Note;
import java.util.List;

public interface NoteDao {
  public Boolean saveNote(Note note);

  public Boolean deleteNote(int noteId);

  public List<Note> getAllNotes();

  public Note getNoteById(int id);

  public Boolean updateNote(Note note);
}
