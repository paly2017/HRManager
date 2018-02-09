package com.example.demo.eneity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Move {
  @Id
  @GeneratedValue
  private Long id;
  private Long employeeNumber;
  private Long before;
  private Long after;
  private java.sql.Timestamp time;
  private String manager;
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


  public Long getBefore() {
    return before;
  }

  public void setBefore(Long before) {
    this.before = before;
  }


  public Long getAfter() {
    return after;
  }

  public void setAfter(Long after) {
    this.after = after;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
