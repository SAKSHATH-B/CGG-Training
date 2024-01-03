package com.cgg.Fetching.BatchFetching;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "department")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "dept_name", length = 100, nullable = false)
  private String deptName;

  //   @BatchSize(size = 3)
  //   @Fetch(value = FetchMode.SELECT)
  //   @Fetch(value = FetchMode.SUBSELECT)
  //   @Fetch(value = FetchMode.JOIN)
  @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
  @OrderColumn(name = "order_id")
  @LazyCollection(value = LazyCollectionOption.EXTRA)
  private List<Employee> employees = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }
}
