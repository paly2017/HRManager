package com.example.demo.eneity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class History {
  @Id
  @GeneratedValue
  private long id;
  private long employeeNumber;
  private String name;
  private String gender;
  private java.sql.Date birthday;
  private String telephone;
  private String email;
  private String address;
  private String photo;
  private String education;
  private java.sql.Date inTime;
  private java.sql.Date outTime;
  private long departmentNumber;
  private long positionNumber;
  private String status;
  private String home;
  private String notes;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(long employeeNumber) {
    this.employeeNumber = employeeNumber;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public java.sql.Date getBirthday() {
    return birthday;
  }

  public void setBirthday(java.sql.Date birthday) {
    this.birthday = birthday;
  }


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }


  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }


  public java.sql.Date getInTime() {
    return inTime;
  }

  public void setInTime(java.sql.Date inTime) {
    this.inTime = inTime;
  }


  public java.sql.Date getOutTime() {
    return outTime;
  }

  public void setOutTime(java.sql.Date outTime) {
    this.outTime = outTime;
  }


  public long getDepartmentNumber() {
    return departmentNumber;
  }

  public void setDepartmentNumber(long departmentNumber) {
    this.departmentNumber = departmentNumber;
  }


  public long getPositionNumber() {
    return positionNumber;
  }

  public void setPositionNumber(long positionNumber) {
    this.positionNumber = positionNumber;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getHome() {
    return home;
  }

  public void setHome(String home) {
    this.home = home;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
