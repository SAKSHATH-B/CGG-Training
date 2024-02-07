package com.stackroute.keepnote.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

/*
 * The class "Note" will be acting as the data model for the Note data in the ArrayList.
 */
@Entity
public class Note {

  /*
   * This class should have five fields (noteId, noteTitle, noteContent,
   * noteStatus and createdAt). This class should also contain the getters and
   * setters for the fields. The value of createdAt should not be accepted from
   * the user but should be always initialized with the system date
   */

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int noteId;

  private String noteTitle;
  private String noteContent;
  private String noteStatus;
  private final LocalDateTime createdAt = LocalDateTime.now();

  public Note() {}

  /* All the getters/setters definition should be implemented here */

  @Override
  public String toString() {
    return (
      "Note [noteId=" +
      noteId +
      ", noteTitle=" +
      noteTitle +
      ", noteContent=" +
      noteContent +
      ", noteStatus=" +
      noteStatus +
      ", createdAt=" +
      createdAt +
      "]"
    );
  }

  /* Override the toString() method */

  public int getNoteId() {
    return noteId;
  }

  public void setNoteId(int noteId) {
    this.noteId = noteId;
  }

  public String getNoteTitle() {
    return noteTitle;
  }

  public void setNoteTitle(String noteTitle) {
    this.noteTitle = noteTitle;
  }

  public String getNoteContent() {
    return noteContent;
  }

  public void setNoteContent(String noteContent) {
    this.noteContent = noteContent;
  }

  public String getNoteStatus() {
    return noteStatus;
  }

  public void setNoteStatus(String noteStatus) {
    this.noteStatus = noteStatus;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
