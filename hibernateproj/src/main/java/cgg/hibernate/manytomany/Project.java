package cgg.hibernate.manytomany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project {

  @Id
  @Column(name = "project_id")
  private int projectId;

  @Column(name = "project_name")
  private String projectName;

  @ManyToMany(mappedBy = "projects")
  private List<Employee> employees;

  public Project(int projectId, String projectName, List<Employee> employees) {
    this.projectId = projectId;
    this.projectName = projectName;
    this.employees = employees;
  }

  public Project() {}

  public int getProjectId() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    this.projectId = projectId;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    return (
      "Project [projectId=" +
      projectId +
      ", projectName=" +
      projectName +
      ", employees=" +
      employees +
      "]"
    );
  }
}
