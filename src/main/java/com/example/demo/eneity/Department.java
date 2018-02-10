package com.example.demo.eneity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department {
  @Id
  @GeneratedValue
  private Long id;
  private Long departmentNumber;
  private String name;
  private String manager;
  private String telephone;
  private String address;
  private String notes;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getDepartmentNumber() {
    return departmentNumber;
  }

  public void setDepartmentNumber(long departmentNumber) {
    this.departmentNumber = departmentNumber;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
  }


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
