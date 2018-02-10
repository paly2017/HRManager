package com.example.demo.eneity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
  @Id
  @GeneratedValue
  private Long id;
  private Long employeeNumber;
  private String name;
  private String gender;
  private java.sql.Date birthday;
  private String telephone;
  private String email;
  private String address;
  private String photo;
  private String education;
  private Long departmentNumber;
  private Long positionNumber;
  private java.sql.Date inTime;
  private String password;
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


  public Long getDepartmentNumber() {
    return departmentNumber;
  }

  public void setDepartmentNumber(Long departmentNumber) {
    this.departmentNumber = departmentNumber;
  }


  public Long getPositionNumber() {
    return positionNumber;
  }

  public void setPositionNumber(Long positionNumber) {
    this.positionNumber = positionNumber;
  }


  public java.sql.Date getInTime() {
    return inTime;
  }

  public void setInTime(java.sql.Date inTime) {
    this.inTime = inTime;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", employeeNumber=" + employeeNumber +
            ", name='" + name + '\'' +
            ", gender='" + gender + '\'' +
            ", birthday=" + birthday +
            ", telephone='" + telephone + '\'' +
            ", email='" + email + '\'' +
            ", address='" + address + '\'' +
            ", photo='" + photo + '\'' +
            ", education='" + education + '\'' +
            ", departmentNumber=" + departmentNumber +
            ", positionNumber=" + positionNumber +
            ", inTime=" + inTime +
            ", password='" + password + '\'' +
            ", notes='" + notes + '\'' +
            '}';
  }
}
