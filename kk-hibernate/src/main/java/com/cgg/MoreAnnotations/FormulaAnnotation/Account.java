package com.cgg.MoreAnnotations.FormulaAnnotation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "account")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "credit_amt")
  private Double credit;

  @Column(name = "rate_amt")
  private Double rate;

  @Formula(value = "credit_amt * rate_amt")
  private Double interest;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getCredit() {
    return credit;
  }

  public void setCredit(Double credit) {
    this.credit = credit;
  }

  public Double getRate() {
    return rate;
  }

  public void setRate(Double rate) {
    this.rate = rate;
  }

  public Double getInterest() {
    return interest;
  }

  public void setInterest(Double interest) {
    this.interest = interest;
  }

  @Override
  public String toString() {
    return (
      "Account [id=" +
      id +
      ", credit=" +
      credit +
      ", rate=" +
      rate +
      ", interest=" +
      interest +
      "]"
    );
  }
}
