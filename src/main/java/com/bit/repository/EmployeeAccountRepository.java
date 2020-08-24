package com.bit.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bit.entity.EmployeeEntity;

public interface EmployeeAccountRepository extends JpaRepository<EmployeeEntity,Serializable> {

	public EmployeeEntity findByEmailIdAndPassword(String emailId,String password);
	//public EmployeeEntity findByEmployeeId(Integer employeeId);
	//@Query(value = "select employeeId from EmployeeEntity where role=:role")
	public List<EmployeeEntity> findByRole(String role);

}
