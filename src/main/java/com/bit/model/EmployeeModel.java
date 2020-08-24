package com.bit.model;

import javax.persistence.Column;

import lombok.Data;

@Data
public class EmployeeModel {
	public Integer employeeId;
	public String firstName;
	public String lastName;
	public String emailId;
	public Character gender;
	public String role;
	public String password; 
	public char isDeleted;
	public String accountStatus;
}
