package com.stackroute.keepnote.service;

import com.stackroute.keepnote.dao.ReminderDAO;
import com.stackroute.keepnote.exceptions.ReminderNotFoundException;
import com.stackroute.keepnote.model.Reminder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Service classes are used here to implement additional business logic/validation
 * This class has to be annotated with @Service annotation.
 * @Service - It is a specialization of the component annotation. It doesn�t currently
 * provide any additional behavior over the @Component annotation, but it�s a good idea
 * to use @Service over @Component in service-layer classes because it specifies intent
 * better. Additionally, tool support and additional behavior might rely on it in the
 * future.
 * */
@Service
public class ReminderServiceImpl implements ReminderService {

  /*
   * Autowiring should be implemented for the ReminderDAO. (Use Constructor-based
   * autowiring) Please note that we should not create any object using the new
   * keyword.
   */
  @Autowired
  ReminderDAO reminderDAO;

  /*
   * This method should be used to save a new reminder.
   */

  public boolean createReminder(Reminder reminder) {
    return reminderDAO.createReminder(reminder);
  }

  /*
   * This method should be used to update a existing reminder.
   */

  public Reminder updateReminder(Reminder reminder, int reminderId)
    throws ReminderNotFoundException {
    Reminder reminderById = reminderDAO.getReminderById(reminderId);
    if (reminderById != null) {
      reminderDAO.updateReminder(reminderById);
    } else {
      throw new ReminderNotFoundException("Reminder not found...");
    }
    return reminder;
  }

  /* This method should be used to delete an existing reminder. */

  public boolean deleteReminder(int reminderId) {
    return reminderDAO.deleteReminder(reminderId);
  }

  /*
   * This method should be used to get a reminder by reminderId.
   */

  public Reminder getReminderById(int reminderId)
    throws ReminderNotFoundException {
    Reminder reminderById = reminderDAO.getReminderById(reminderId);
    if (reminderById != null) {
      return reminderById;
    } else {
      throw new ReminderNotFoundException("Reminder not found...");
    }
  }

  /*
   * This method should be used to get a reminder by userId.
   */

  public List<Reminder> getAllReminderByUserId(int userId) {
    return reminderDAO.getAllReminderByUserId(userId);
  }
}
