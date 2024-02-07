package com.stackroute.keepnote.service;

import com.stackroute.keepnote.dao.NoteDao;
import com.stackroute.keepnote.exceptions.CategoryNotFoundException;
import com.stackroute.keepnote.exceptions.NoteNotFoundException;
import com.stackroute.keepnote.exceptions.ReminderNotFoundException;
import com.stackroute.keepnote.model.Note;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

  @Autowired
  NoteDao noteDao;

  @Override
  public boolean createNote(Note note)
    throws ReminderNotFoundException, CategoryNotFoundException {
    noteDao.createNote(note);
    System.out.println("New Note Created");
    return true;
  }

  @Override
  public boolean deleteNote(int noteId) {
    return noteDao.deleteNote(noteId);
  }

  @Override
  public List<Note> getAllNotesByUserId(int userId) {
    List<Note> allNotesByUserId = noteDao.getAllNotesByUserId();
    return allNotesByUserId;
  }

  @Override
  public Note getNoteById(int noteId) throws NoteNotFoundException {
    Note noteById = noteDao.getNoteById(noteId);
    if (noteById != null) {
      return noteById;
    } else {
      throw new NoteNotFoundException("Note not found...");
    }
  }

  @Override
  public Note updateNote(Note note, int noteId)
    throws ReminderNotFoundException, NoteNotFoundException, CategoryNotFoundException {
    Note noteById = noteDao.getNoteById(noteId);
    if (noteById != null) {
      noteDao.updateNote(noteById);
    } else {
      throw new NoteNotFoundException("Note not found to update...");
    }
    return note;
  }
}
