package com.stackroute.keepnote.dao;

import com.stackroute.keepnote.exceptions.ReminderNotFoundException;
import com.stackroute.keepnote.model.Reminder;
import jakarta.transaction.Transactional;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/*
 * This class is implementing the UserDAO interface. This class has to be annotated with
 * @Repository annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object,
 * thus clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database
 * 					transaction. The database transaction happens inside the scope of a persistence
 * 					context.
 * */
@Repository
@Transactional
public class ReminderDAOImpl implements ReminderDAO {

  /*
   * Autowiring should be implemented for the SessionFactory.(Use
   * constructor-based autowiring.
   */
  SessionFactory sessionFactory;

  public ReminderDAOImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /*
   * Create a new reminder
   */

  public boolean createReminder(Reminder reminder) {
    sessionFactory.getCurrentSession().persist(reminder);
    return true;
  }

  /*
   * Update an existing reminder
   */

  public boolean updateReminder(Reminder reminder) {
    Reminder merge = sessionFactory.getCurrentSession().merge(reminder);
    if (merge != null) {
      return true;
    }
    return false;
  }

  /*
   * Remove an existing reminder
   */

  public boolean deleteReminder(int reminderId) {
    Reminder reminderById = sessionFactory
      .getCurrentSession()
      .find(Reminder.class, reminderId);
    if (reminderById != null) {
      sessionFactory.getCurrentSession().remove(reminderById);
      return true;
    }
    return false;
  }

  /*
   * Retrieve details of a specific reminder
   */

  public Reminder getReminderById(int reminderId)
    throws ReminderNotFoundException {
    Reminder reminderById = sessionFactory
      .getCurrentSession()
      .find(Reminder.class, reminderId);
    return reminderById;
  }

  /*
   * Retrieve details of all reminders by userId
   */

  public List<Reminder> getAllReminderByUserId(int userId) {
    List<Reminder> allRemindersByUserId = sessionFactory
      .getCurrentSession()
      .createQuery("from Reminder", Reminder.class)
      .getResultList();
    return allRemindersByUserId;
  }
}
