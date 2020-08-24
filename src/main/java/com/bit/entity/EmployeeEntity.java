package com.bit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Data
@Entity
@Table(name = "HIS_EMPLOYEE_ACCOUNT_DETAILS")
public class EmployeeEntity {
	static int i=0;
	@Id
	@SequenceGenerator(
			name = "Eid_seq_gen",
			sequenceName = "GENERALSEQ",
			allocationSize = 1
			)
	@GeneratedValue(generator ="Eid_seq_gen",
					strategy = GenerationType.SEQUENCE
					)
	@Column(name = "EMPLOYEE_ID")
	public Integer employeeId;
	@Column(name = "EMPLOYEE_FIRST_NAME")
	public String firstName;
	@Column(name = "EMPLOYEE_LAST_NAME")
	public String lastName;
	@Column(name = "EMPLOYEE_EMAIL_ID")
	public String emailId;
	@Column(name = "EMPLOYEE_GENDER")
	public Character gender;
	@Column(name = "EMPLOYEE_ROLE")
	public String role;
	@Column(name = "ACCOUNT_IS_DELETED")
	public char isDeleted;
	@Column(name = "ACCOUNT_STATUS")
	public String accountStatus;
	@Column(name = "EMPLOYEE_PASSWORD")
	public String password;

}
