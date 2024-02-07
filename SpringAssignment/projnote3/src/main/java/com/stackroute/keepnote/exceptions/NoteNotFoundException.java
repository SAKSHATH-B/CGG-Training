package com.stackroute.keepnote.exceptions;

public class NoteNotFoundException extends Exception {

  public NoteNotFoundException(String message) {
    super(message);
  }

  public NoteNotFoundException() {}
}
