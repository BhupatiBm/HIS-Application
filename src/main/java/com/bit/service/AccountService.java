package com.bit.service;

import java.util.List;

import com.bit.model.EmployeeModel;

public interface AccountService {
	public boolean saveEmployeeDetails(EmployeeModel model);
	  public boolean updateEmployeeDetails(EmployeeModel model); 
	//public boolean UpdateEmployeeDetails(EmployeeModel model);
	public EmployeeModel findEmployeeByEmailAndTempPAssword(String email,String tempPassword);
	public List<EmployeeModel> getAllEmployeesDetails();
	public EmployeeModel getEmployeeByEmployeeId(int eid);
	public List<EmployeeModel> getEmployeeByRole(String role);
}
