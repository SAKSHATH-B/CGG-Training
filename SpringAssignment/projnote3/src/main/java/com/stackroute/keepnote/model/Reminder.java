package com.stackroute.keepnote.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Reminder {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int reminderId;

  private String reminderName;
  private String reminderDescription;
  private String reminderType;
  private int reminderCreatedBy;
  private final LocalDateTime reminderCreationDate = LocalDateTime.now();

  @OneToMany(mappedBy = "reminder")
  private List<Note> notes;

  public Reminder(
    int reminderId,
    String reminderName,
    String reminderDescription,
    String reminderType,
    int reminderCreatedBy,
    List<Note> notes
  ) {
    this.reminderId = reminderId;
    this.reminderName = reminderName;
    this.reminderDescription = reminderDescription;
    this.reminderType = reminderType;
    this.reminderCreatedBy = reminderCreatedBy;
    this.notes = notes;
  }

  public Reminder() {}

  public int getReminderId() {
    return reminderId;
  }

  public void setReminderId(int reminderId) {
    this.reminderId = reminderId;
  }

  public String getReminderName() {
    return reminderName;
  }

  public void setReminderName(String reminderName) {
    this.reminderName = reminderName;
  }

  public String getReminderDescription() {
    return reminderDescription;
  }

  public void setReminderDescription(String reminderDescription) {
    this.reminderDescription = reminderDescription;
  }

  public String getReminderType() {
    return reminderType;
  }

  public void setReminderType(String reminderType) {
    this.reminderType = reminderType;
  }

  public int getReminderCreatedBy() {
    return reminderCreatedBy;
  }

  public void setReminderCreatedBy(int reminderCreatedBy) {
    this.reminderCreatedBy = reminderCreatedBy;
  }

  public LocalDateTime getReminderCreationDate() {
    return reminderCreationDate;
  }

  public List<Note> getNotes() {
    return notes;
  }

  public void setNotes(List<Note> notes) {
    this.notes = notes;
  }

  @Override
  public String toString() {
    return (
      "Reminder [reminderId=" +
      reminderId +
      ", reminderName=" +
      reminderName +
      ", reminderDescription=" +
      reminderDescription +
      ", reminderType=" +
      reminderType +
      ", reminderCreatedBy=" +
      reminderCreatedBy +
      ", reminderCreationDate=" +
      reminderCreationDate +
      ", notes=" +
      notes +
      "]"
    );
  }
}
