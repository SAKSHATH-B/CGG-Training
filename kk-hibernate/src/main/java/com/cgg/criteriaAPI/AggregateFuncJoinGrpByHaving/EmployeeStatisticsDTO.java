package com.cgg.criteriaAPI.AggregateFuncJoinGrpByHaving;

public class EmployeeStatisticsDTO {

  private Long totalNoofEmp;
  private Long distinctNoOfEmp;

  private Double maxSalOfEmp;
  private Double avgSalOfEmp;
  private Double sumOfSalOfEmp;

  public EmployeeStatisticsDTO(
    Long totalNoofEmp,
    Long distinctNoOfEmp,
    Double maxSalOfEmp,
    Double avgSalOfEmp,
    Double sumOfSalOfEmp
  ) {
    this.totalNoofEmp = totalNoofEmp;
    this.distinctNoOfEmp = distinctNoOfEmp;
    this.maxSalOfEmp = maxSalOfEmp;
    this.avgSalOfEmp = avgSalOfEmp;
    this.sumOfSalOfEmp = sumOfSalOfEmp;
  }

  public Long getTotalNoofEmp() {
    return totalNoofEmp;
  }

  public Long getDistinctNoOfEmp() {
    return distinctNoOfEmp;
  }

  public Double getMaxSalOfEmp() {
    return maxSalOfEmp;
  }

  public Double getAvgSalOfEmp() {
    return avgSalOfEmp;
  }

  public Double getSumOfSalOfEmp() {
    return sumOfSalOfEmp;
  }

  @Override
  public String toString() {
    return (
      "EmployeeStatisticsDTO [totalNoofEmp=" +
      totalNoofEmp +
      ", distinctNoOfEmp=" +
      distinctNoOfEmp +
      ", maxSalOfEmp=" +
      maxSalOfEmp +
      ", avgSalOfEmp=" +
      avgSalOfEmp +
      ", sumOfSalOfEmp=" +
      sumOfSalOfEmp +
      "]"
    );
  }
}
