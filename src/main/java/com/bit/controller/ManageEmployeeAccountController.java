package com.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.constant.ApplicationConstant;
import com.bit.model.EmployeeModel;
import com.bit.model.EmployeeRoleModel;
import com.bit.service.AccountService;

@Controller 
public class ManageEmployeeAccountController {
	@Autowired
	private AccountService accountService;
	@GetMapping("/viewAllEmployee")
	public String viewAllEmpoyee(Model model,@ModelAttribute("EmployeeRole")EmployeeRoleModel Role) {
		//List<EmployeeModel> employeeByRole = accountService.getEmployeeByRole(Role.getRole());
		List<EmployeeModel> allEmployeeModel= accountService.getAllEmployeesDetails();
		model.addAttribute("allEmployeeDetails",allEmployeeModel);
		System.out.println("**********************"+allEmployeeModel);
		return "viewAllEmployeeDetails";
	}
	
	@GetMapping("/viewEmployeebyRole")
	@ResponseBody
	public List<EmployeeModel> viewbyRole(@RequestParam("role")String role,Model model) {
		List<EmployeeModel> employeeByRole = accountService.getEmployeeByRole(role);
		System.out.println("**********************"+employeeByRole);
		
		model.addAttribute("allEmployeeDetails",employeeByRole);
		return employeeByRole;
	}
	 
	@GetMapping("/editEmployeeAccount")
	public String editEmployeeAccount(@RequestParam("eid")String eid,Model model) {
		EmployeeModel employeeByEmailId = accountService.getEmployeeByEmployeeId(Integer.valueOf(eid));
		model.addAttribute("Employeemodel",employeeByEmailId);
		return "CreateEmployeeAccount";
	}
	
	@GetMapping("/softDeleteAccount")
	public String softDeleteEmployeeAccount(@RequestParam("eid")String eid,Model model) {
		EmployeeModel employeeByEmailId = accountService.getEmployeeByEmployeeId(Integer.valueOf(eid));
		if(employeeByEmailId!=null)
		{
			employeeByEmailId.setIsDeleted(ApplicationConstant.SUCESS_IS_DELETED_VALUE);
			accountService.updateEmployeeDetails(employeeByEmailId);
		}
		model.addAttribute("Employeemodel",employeeByEmailId);
		return "redirect:/viewAllEmployee";
	}
	
	@GetMapping("/activeDeletedAccount")
	public String activeDeletedEmployeeAccount(@RequestParam("eid")String eid,Model model) {
		EmployeeModel employeeByEmailId = accountService.getEmployeeByEmployeeId(Integer.valueOf(eid));
		if(employeeByEmailId!=null)
		{
			employeeByEmailId.setIsDeleted(ApplicationConstant.DEFAULT_IS_DELETED_VALUE);
			accountService.updateEmployeeDetails(employeeByEmailId);
		}
		model.addAttribute("Employeemodel",employeeByEmailId);
		return "redirect:/viewAllEmployee";
	}

}
