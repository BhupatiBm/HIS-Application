package com.bit.service;

import java.applet.AppletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Entity;

import org.apache.naming.factory.SendMailFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.constant.ApplicationConstant;
import com.bit.entity.EmployeeEntity;
import com.bit.model.EmployeeModel;
import com.bit.repository.EmployeeAccountRepository;
import com.bit.utils.PasswordGeneratorUtil;
import com.bit.utils.SendEmailUtils;
@Service
public class AccountServiceImpl  implements AccountService{

	@Autowired
	private EmployeeAccountRepository employeeAccRepo;
	@Autowired
	private SendEmailUtils emailUtil;
	@Autowired
	private PasswordGeneratorUtil passwordUtil;
	@Override
	public boolean saveEmployeeDetails(EmployeeModel empModel) {
		empModel.setPassword(passwordUtil.generatePassword(ApplicationConstant.DEFAULT_PASSWORD_LENGTH));
		EmployeeEntity entity=new EmployeeEntity();
		BeanUtils.copyProperties(empModel, entity);
		EmployeeEntity employeeEntity = employeeAccRepo.save(entity);
		if(employeeEntity!=null) {
			emailUtil.SendUnlockMailToEmployee(empModel);
			return true; 
		}
		return false;
	}

	@Override
	public EmployeeModel findEmployeeByEmailAndTempPAssword(String email, String tempPassword) {
		EmployeeModel empModel=new EmployeeModel();
		EmployeeEntity empEntity = employeeAccRepo.findByEmailIdAndPassword(email, tempPassword);
		if(empEntity!=null) {
			BeanUtils.copyProperties(emailUtil, empModel);
			return empModel;
		}
		return null;
	}

	@Override
	public boolean updateEmployeeDetails(EmployeeModel model) {
		//List<EmployeeModel> employeeByRole = getEmployeeByRole("Admin");
		EmployeeEntity employeeEntity=new  EmployeeEntity();
		BeanUtils.copyProperties(model, employeeEntity);
		EmployeeEntity savedEntity = employeeAccRepo.save(employeeEntity);
		return savedEntity!=null;
	}

	@Override
	public List<EmployeeModel> getAllEmployeesDetails() {
		List<EmployeeEntity> employeeEntity = employeeAccRepo.findAll();
		return employeeEntity.stream().map(entity->{
			EmployeeModel employeeModel=new EmployeeModel();
			BeanUtils.copyProperties(entity,employeeModel);
			return employeeModel;
		}).collect(Collectors.toList());
	}
	@Override
	public List<EmployeeModel> getEmployeeByRole(String role) {
		List<EmployeeEntity> findByRoleEntity = employeeAccRepo.findByRole(role);
		return findByRoleEntity.stream().map(entity->{
			EmployeeModel employeeModel=new EmployeeModel();
			BeanUtils.copyProperties(entity,employeeModel);
			return employeeModel;
		}).collect(Collectors.toList());
	}
	
	@Override
	public EmployeeModel getEmployeeByEmployeeId(int eid) {
		EmployeeModel employeeModel=null;
		Optional<EmployeeEntity> findById = employeeAccRepo.findById(eid);
		if(findById!=null) {
			EmployeeEntity entity=findById.get();
			employeeModel=new EmployeeModel();
			BeanUtils.copyProperties(entity, employeeModel);
		}
		return employeeModel;
	}

	

//	@Override
//	public boolean UpdateEmployeeDetails(EmployeeModel model) {
//		model.setPassword(passwordUtil.generatePassword(ApplicationConstant.DEFAULT_PASSWORD_LENGTH));
//		EmployeeEntity entity=new EmployeeEntity();
//		BeanUtils.copyProperties(model, entity);
//		EmployeeEntity employeeEntity = employeeAccRepo.save(entity);
//		getEmployeeByRole("Admin");
//		if(employeeEntity!=null) {
//			return true; 
//		}
//		return false;
//	}

	

	

}
