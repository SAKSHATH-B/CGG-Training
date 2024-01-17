package cgg.spring.core;

import java.util.List;
import java.util.Set;

public class OrgInfo {

  private Student[] stuArr = new Student[2];
  private List<Student> stuList;
  private Set<Student> stuSet;

  public Student[] getStuArr() {
    return stuArr;
  }

  public void setStuArr(Student[] stuArr) {
    this.stuArr = stuArr;
  }

  public List<Student> getStuList() {
    return stuList;
  }

  public void setStuList(List<Student> stuList) {
    this.stuList = stuList;
  }

  public Set<Student> getStuSet() {
    return stuSet;
  }

  public void setStuSet(Set<Student> stuSet) {
    this.stuSet = stuSet;
  }
}
