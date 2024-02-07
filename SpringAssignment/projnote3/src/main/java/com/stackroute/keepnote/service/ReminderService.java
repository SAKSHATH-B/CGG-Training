package com.stackroute.keepnote.service;

import com.stackroute.keepnote.exceptions.ReminderNotFoundException;
import com.stackroute.keepnote.model.Reminder;
import java.util.List;

public interface ReminderService {
  /*
   * Should not modify this interface. You have to implement these methods in
   * corresponding Impl classes
   */
  public boolean createReminder(Reminder reminder);

  public Reminder updateReminder(Reminder reminder, int reminderId)
    throws ReminderNotFoundException;

  public boolean deleteReminder(int reminderId);

  public Reminder getReminderById(int reminderId)
    throws ReminderNotFoundException;

  public List<Reminder> getAllReminderByUserId(int userId);
}
