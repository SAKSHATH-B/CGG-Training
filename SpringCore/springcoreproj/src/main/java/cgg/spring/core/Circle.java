package cgg.spring.core;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.annotation.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {

  private Point center;

  public Circle(Point center) {
    this.center = center;
  }

  public Circle() {}

  public Point getCenter() {
    return center;
  }

  @Autowired
  // @Qualifier(value = "circle related bean")
  public void setCenter(Point center) {
    this.center = center;
  }

  @PostConstruct
  public void initializeCircle() {
    System.out.println("Init of circle");
  }

  @PreDestroy
  public void destroyCircle() {
    System.out.println("Destroy of circle");
  }

  @Override
  public void draw() {
    System.out.println(
      "circle point = (" + center.getX() + "," + center.getY() + ")"
    );
  }
}
