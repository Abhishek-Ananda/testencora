package com.assesment.employee.dto;

import java.math.BigInteger;

public class EmployeeDto {
  private Long id;

  private String name;
  private String email;
  private BigInteger phoneNumber;
  
  
  public BigInteger getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(BigInteger phoneNumber) {
    this.phoneNumber = phoneNumber;
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
  

  public EmployeeDto(Long id, String name, String email, BigInteger phoneNumber) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }
  
  public EmployeeDto() {
    super();
  }
  
  @Override
  public String toString() {
    return "EmployeeDto [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber="
        + phoneNumber + "]";
  }
}
