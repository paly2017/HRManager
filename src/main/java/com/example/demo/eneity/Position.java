package com.example.demo.eneity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Position {
  @Id
  @GeneratedValue
  private Integer id;
  private Integer positionNumber;
  private String name;
  private String level;
  private String notes;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getPositionNumber() {
    return positionNumber;
  }

  public void setPositionNumber(Integer positionNumber) {
    this.positionNumber = positionNumber;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
