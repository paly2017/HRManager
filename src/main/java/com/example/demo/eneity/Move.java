package com.example.demo.eneity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Move {
  @Id
  @GeneratedValue
  private Integer id;
  private Integer employeeNumber;
  private Integer before;
  private Integer after;
  private java.sql.Timestamp time;
  private String manager;
  private String notes;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(Integer employeeNumber) {
    this.employeeNumber = employeeNumber;
  }


  public Integer getBefore() {
    return before;
  }

  public void setBefore(Integer before) {
    this.before = before;
  }


  public Integer getAfter() {
    return after;
  }

  public void setAfter(Integer after) {
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
