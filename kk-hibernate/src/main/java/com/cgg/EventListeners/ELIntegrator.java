package com.cgg.EventListeners;

import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class ELIntegrator implements Integrator {

  @Override
  public void disintegrate(
    SessionFactoryImplementor sessionFactory,
    SessionFactoryServiceRegistry serviceRegistry
  ) {
    // TODO Auto-generated method stub

  }

  @Override
  public void integrate(
    Metadata metadata,
    SessionFactoryImplementor sessionFactory,
    SessionFactoryServiceRegistry serviceRegistry
  ) {
    EventListenerRegistry eventListenerRegistry = serviceRegistry.getService(
      EventListenerRegistry.class
    );
    eventListenerRegistry
      .getEventListenerGroup(EventType.SAVE_UPDATE)
      .appendListener(new SaveUpdateEL());
    eventListenerRegistry
      .getEventListenerGroup(EventType.REFRESH)
      .appendListener(new RefreshEL());
    eventListenerRegistry
      .getEventListenerGroup(EventType.LOAD)
      .appendListener(new LoadEL());
  }
}
