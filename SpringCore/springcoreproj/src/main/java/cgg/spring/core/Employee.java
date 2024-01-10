package cgg.spring.core;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Employee {

  private int eid;
  private String ename;

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
}
