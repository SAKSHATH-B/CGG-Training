package cgg.springcore.aop;

public class Circle {

  private String name;
  private String nickName;

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public Circle() {}

  @Loggable
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
