package com.stackroute.keepnote.dao;

import com.stackroute.keepnote.exceptions.ReminderNotFoundException;
import com.stackroute.keepnote.model.Reminder;
import java.util.List;

public interface ReminderDAO {
  /*
   * Should not modify this interface. You have to implement these methods in
   * corresponding Impl classes
   */

  public boolean createReminder(Reminder reminder);

  public boolean updateReminder(Reminder reminder);

  public boolean deleteReminder(int reminderId);

  public Reminder getReminderById(int reminderId)
    throws ReminderNotFoundException;

  public List<Reminder> getAllReminderByUserId(int userId);
}
