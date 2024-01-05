package com.cgg.EventListeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.RefreshContext;
import org.hibernate.event.spi.RefreshEvent;
import org.hibernate.event.spi.RefreshEventListener;

public class RefreshEL implements RefreshEventListener {

  private static Logger logger = LogManager.getLogger(RefreshEL.class);
  private static final long serialVersionUID = 1L;

  @Override
  public void onRefresh(RefreshEvent event) throws HibernateException {
    logger.info("onRefresh method is called...");

    Object object = event.getObject();
    if (object instanceof Person) {
      Person person = (Person) object;
      logger.info(person);
    }
  }

  @SuppressWarnings("rawtypes")
  @Override
  public void onRefresh(RefreshEvent event, RefreshContext refreshedAlready)
    throws HibernateException {
    logger.info("onRefresh method is called...");
  }
}
