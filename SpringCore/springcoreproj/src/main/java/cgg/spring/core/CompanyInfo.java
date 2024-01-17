package cgg.spring.core;

import java.util.Map;

public class CompanyInfo {

  private Map<Integer, String> empIdAndNameMap;
  private Map<Integer, Student> studentIdMap;

  public Map<Integer, String> getEmpIdAndNameMap() {
    return empIdAndNameMap;
  }

  public void setEmpIdAndNameMap(Map<Integer, String> empIdAndNameMap) {
    this.empIdAndNameMap = empIdAndNameMap;
  }

  public Map<Integer, Student> getStudentIdMap() {
    return studentIdMap;
  }

  public void setStudentIdMap(Map<Integer, Student> studentIdMap) {
    this.studentIdMap = studentIdMap;
  }
}
