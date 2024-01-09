package cgg.spring.core;

public class Triangle {

  //   private String type;
  //   private int height;

  //   //   public void setHeight(int height) {
  //   //     this.height = height;
  //   //   }

  //   //   public void setType(String type) {
  //   //     this.type = type;
  //   //   }

  //   public Triangle(int height) {
  //     this.height = height;
  //   }

  //   public Triangle(String type) {
  //     this.type = type;
  //   }

  //   public Triangle(String type, int height) {
  //     this.type = type;
  //     this.height = height;
  //   }

  //   public void draw() {
  //     System.out.println(type + " Triangle of height " + height + " is drawn");
  //   }

  private Point pointA;
  private Point pointB;
  private Point pointC;

  public void draw() {
    System.out.println(
      "point A = (" + pointA.getX() + "," + pointA.getY() + ")"
    );
    System.out.println(
      "point B = (" + pointB.getX() + "," + pointB.getY() + ")"
    );
    System.out.println(
      "point C = (" + pointC.getX() + "," + pointC.getY() + ")"
    );
  }

  public Point getPointA() {
    return pointA;
  }

  public void setPointA(Point pointA) {
    this.pointA = pointA;
  }

  public Point getPointB() {
    return pointB;
  }

  public void setPointB(Point pointB) {
    this.pointB = pointB;
  }

  public Point getPointC() {
    return pointC;
  }

  public void setPointC(Point pointC) {
    this.pointC = pointC;
  }
}
