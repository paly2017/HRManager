package com.example.demo.eneity;

//import org.springframework.data.annotation.Id;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Attendance {
  @Id
  @GeneratedValue
  private Long id;
  private Long employeeNumber;
  private java.sql.Date day;
  private String timeType;
  private java.sql.Time startTime;
  private String startType;
  private java.sql.Time endTime;
  private String endType;
  private String workType;
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


  public java.sql.Date getDay() {
    return day;
  }

  public void setDay(java.sql.Date day) {
    this.day = day;
  }


  public String getTimeType() {
    return timeType;
  }

  public void setTimeType(String timeType) {
    this.timeType = timeType;
  }


  public java.sql.Time getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Time startTime) {
    this.startTime = startTime;
  }


  public String getStartType() {
    return startType;
  }

  public void setStartType(String startType) {
    this.startType = startType;
  }


  public java.sql.Time getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Time endTime) {
    this.endTime = endTime;
  }


  public String getEndType() {
    return endType;
  }

  public void setEndType(String endType) {
    this.endType = endType;
  }


  public String getWorkType() {
    return workType;
  }

  public void setWorkType(String workType) {
    this.workType = workType;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  @Override
  public String toString() {
    return "Attendance{" +
            "id=" + id +
            ", employeeNumber=" + employeeNumber +
            ", day=" + day +
            ", timeType='" + timeType + '\'' +
            ", startTime=" + startTime +
            ", startType='" + startType + '\'' +
            ", endTime=" + endTime +
            ", endType='" + endType + '\'' +
            ", workType='" + workType + '\'' +
            ", notes='" + notes + '\'' +
            '}';
  }
}
