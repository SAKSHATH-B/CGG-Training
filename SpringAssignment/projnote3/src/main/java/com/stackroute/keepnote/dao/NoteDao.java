package com.stackroute.keepnote.dao;

import com.stackroute.keepnote.model.Note;
import java.util.List;

public interface NoteDao {
  public Boolean createNote(Note note);

  public Boolean deleteNote(int noteId);

  public List<Note> getAllNotesByUserId();

  public Note getNoteById(int noteId);

  public Boolean updateNote(Note note);
}
