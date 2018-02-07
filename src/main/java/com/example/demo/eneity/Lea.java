package com.example.demo.eneity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lea {
  @Id
  @GeneratedValue
  private Long id;
  private Long employeeNumber;
  private Long departmentNumber;
  private java.sql.Date startTime;
  private java.sql.Date endTime;
  private String days;
  private String reason;
  private String type;
  private String manager;
  private String status;
  private String notes;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(Long employeeNumber) {
    this.employeeNumber = employeeNumber;
  }


  public Long getDepartmentNumber() {
    return departmentNumber;
  }

  public void setDepartmentNumber(Long departmentNumber) {
    this.departmentNumber = departmentNumber;
  }


  public java.sql.Date getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Date startTime) {
    this.startTime = startTime;
  }


  public java.sql.Date getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Date endTime) {
    this.endTime = endTime;
  }


  public String getDays() {
    return days;
  }

  public void setDays(String days) {
    this.days = days;
  }


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
