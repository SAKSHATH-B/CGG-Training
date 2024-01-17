package cgg.spring.core;

import org.springframework.stereotype.Component;

@Component
public class Employee {

  private int eid;
  private String ename;
  private String address;

  public Employee() {}

  public Employee(int eid, String ename) {
    this.eid = eid;
    this.ename = ename;
  }

  public int getEid() {
    return eid;
  }

  public void setEid(int eid) {
    this.eid = eid;
  }

  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
