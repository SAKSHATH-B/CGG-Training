package cgg.hibernate.inheritance;

import jakarta.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {

  private String SteeringHandle;

  public String getSteeringHandle() {
    return SteeringHandle;
  }

  public void setSteeringHandle(String steeringHandle) {
    SteeringHandle = steeringHandle;
  }
}
