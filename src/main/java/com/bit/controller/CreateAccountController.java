package com.bit.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bit.constant.ApplicationConstant;
import com.bit.model.EmployeeModel;
import com.bit.service.AccountService;

@Controller
public class CreateAccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value = {"/","/createAccount"})
	public String showCreateAccountPage(Model model) {
		EmployeeModel Employeemodel=new EmployeeModel();
		model.addAttribute("Employeemodel",Employeemodel);
		return "CreateEmployeeAccount";
	}
	
	@PostMapping(value = "/SaveAccountDetails")
	public String SaveEmpoyeeDetailsInDB(@ModelAttribute("Employeemodel")EmployeeModel Empmodel,Model model ) {
		String message=null;
		Empmodel.setIsDeleted(ApplicationConstant.DEFAULT_IS_DELETED_VALUE);
		Empmodel.setAccountStatus(ApplicationConstant.DEFAULT_ACCOUNT_STATUS);
		boolean saveEmployeeDetails = accountService.saveEmployeeDetails(Empmodel);
		if(saveEmployeeDetails==true)
			 return "redirect:/doublepost?isSaved=true"; 
		else
			return "redirect:/doublepost?isSaved=false";
//			message="Error occoured";	
//		model.addAttribute("msg",message);
		
	}
	
	@GetMapping(value = {"/doublepost"})
	public String solveDoublePostProblem(@RequestParam("isSaved")boolean isSaved , Model model) {
		String message=null;
		EmployeeModel empmodel=new EmployeeModel();
		model.addAttribute("Employeemodel", empmodel);
		if(isSaved)
			message="Done";
		else
			message="Error occoured";
		
		model.addAttribute("msg",message);
		return "CreateEmployeeAccount";
	}

}
