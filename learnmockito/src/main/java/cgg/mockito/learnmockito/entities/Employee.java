package cgg.mockito.learnmockito.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_table")
public class Employee {

  @Id
  @GeneratedValue
  @Column(name = "employee_id")
  private int employee_id;

  @Column(name = "employee_name")
  private String employeeName;

  private String email;
  private Double salary;

  @Column(name = "date_of_joining")
  private Date doj;

  private BigDecimal bonus;
}
