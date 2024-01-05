package com.cgg.EventListeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;

public class SaveUpdateEL implements SaveOrUpdateEventListener {

  private static Logger logger = LogManager.getLogger(SaveUpdateEL.class);
  private static final long serialVersionUID = 1L;

  @Override
  public void onSaveOrUpdate(SaveOrUpdateEvent event)
    throws HibernateException {
    logger.info("onSaveOrUpdate method is called...");
    Object object = event.getEntity();
    if (object instanceof Person) {
      Person person = (Person) object;
      logger.info(person);
    }
  }
}
