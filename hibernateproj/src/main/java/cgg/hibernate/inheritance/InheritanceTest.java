package cgg.hibernate.inheritance;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class InheritanceTest {

  public static void main(String[] args) {
    Vehicle vehicle = new Vehicle();
    vehicle.setVehicleName("Car");

    TwoWheeler twoWheeler = new TwoWheeler();
    twoWheeler.setVehicleName("GT650");
    twoWheeler.setSteeringHandle("Straight with slightly tilted handle");

    FourWheeler fourWheeler = new FourWheeler();
    fourWheeler.setVehicleName("Ford Mustang GT");
    fourWheeler.setSteeringWheel("Rounded with PaddleShifters");

    Session session = new Configuration()
      .configure()
      .buildSessionFactory()
      .openSession();

    session.beginTransaction();

    session.persist(vehicle);
    session.persist(twoWheeler);
    session.persist(fourWheeler);

    session.getTransaction().commit();
    session.close();
  }
}
