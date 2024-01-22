package cgg.spring.core;

import org.springframework.stereotype.Component;

@Component
public class Employee {

  private int eid;
  private String ename;
  private String address;
  private Pancard pancard;

  public Employee(int eid, String ename, String address, Pancard pancard) {
    this.eid = eid;
    this.ename = ename;
    this.address = address;
    this.pancard = pancard;
  }

  public Pancard getPancard() {
    return pancard;
  }

  public void setPancard(Pancard pancard) {
    this.pancard = pancard;
  }

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
