package com.cgg;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class connection {

  public static SessionFactory getSessionFactory() {
    return new Configuration().configure().buildSessionFactory();
  }
}
