package com.assesment.employee.entity;

import java.math.BigInteger;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")    
public class EmployeeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String email;
  private BigInteger phoneNumber;
  
  

  
  
  public EmployeeEntity(Long id, String name, String email, BigInteger phoneNumber) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }


  public EmployeeEntity() {
    super();
  }


  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }


  public BigInteger getPhoneNumber() {
    return phoneNumber;
  }


  public void setPhoneNumber(BigInteger phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  @Override
  public String toString() {
    return "EmployeeEntity [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber="
        + phoneNumber + "]";
  }

  

}
