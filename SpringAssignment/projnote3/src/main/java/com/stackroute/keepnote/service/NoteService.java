package com.stackroute.keepnote.service;

import com.stackroute.keepnote.exceptions.CategoryNotFoundException;
import com.stackroute.keepnote.exceptions.NoteNotFoundException;
import com.stackroute.keepnote.exceptions.ReminderNotFoundException;
import com.stackroute.keepnote.model.Note;
import java.util.List;

public interface NoteService {
  public boolean createNote(Note note)
    throws ReminderNotFoundException, CategoryNotFoundException;

  public boolean deleteNote(int noteId);

  public List<Note> getAllNotesByUserId(int userId);

  public Note getNoteById(int noteId) throws NoteNotFoundException;

  public Note updateNote(Note note, int noteId)
    throws ReminderNotFoundException, NoteNotFoundException, CategoryNotFoundException;
}
