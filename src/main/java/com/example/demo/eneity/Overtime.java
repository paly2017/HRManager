package com.example.demo.eneity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Overtime {
  @Id
  @GeneratedValue
  private Integer id;
  private Integer departmentNumber;
  private Integer employeeNumber;
  private java.sql.Date day;
  private java.sql.Time startTime;
  private java.sql.Time endTime;
  private String notes;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getDepartmentNumber() {
    return departmentNumber;
  }

  public void setDepartmentNumber(Integer departmentNumber) {
    this.departmentNumber = departmentNumber;
  }


  public Integer getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(Integer employeeNumber) {
    this.employeeNumber = employeeNumber;
  }


  public java.sql.Date getDay() {
    return day;
  }

  public void setDay(java.sql.Date day) {
    this.day = day;
  }


  public java.sql.Time getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Time startTime) {
    this.startTime = startTime;
  }


  public java.sql.Time getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Time endTime) {
    this.endTime = endTime;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
