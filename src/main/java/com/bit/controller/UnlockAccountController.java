package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.constant.ApplicationConstant;
import com.bit.model.EmployeeModel;
import com.bit.model.UnlockEmployeeAccountModel;
import com.bit.service.AccountService;
import com.bit.service.AccountServiceImpl;
@Controller
public class UnlockAccountController {
	@Autowired
	private AccountService employeeAccService;
	@GetMapping("/unlockAccountForm")
	public String showUnlockAccountForm(@RequestParam("email")String email,Model model) {
		UnlockEmployeeAccountModel unlockAccModel=new UnlockEmployeeAccountModel();
		unlockAccModel.setEmailId(email);
		model.addAttribute("unlockModel", unlockAccModel);
;		return "UnlockEmployeeAccount";
	}
	
	@PostMapping("/unlockEmployeeAccount")
	public String handelUnlockAccount(@ModelAttribute("unlockModel")UnlockEmployeeAccountModel unlockModel,
										Model model) {
		EmployeeModel employeeModel = employeeAccService.findEmployeeByEmailAndTempPAssword(unlockModel.getEmailId(), unlockModel.getTemporaryPassword());
		
		if(employeeModel!=null) {
			employeeModel.setPassword(unlockModel.getConfirmPassword());
			employeeModel.setAccountStatus(ApplicationConstant.UNLOCK_ACCOUNT_STATUS);
			boolean isUpdated = employeeAccService.updateEmployeeDetails(employeeModel);
			if(isUpdated) {
				model.addAttribute("succMsg","Password changed and Account Activated");
			return "UnlockEmployeeAccount";
			}
		}
		model.addAttribute("errMsg","Account is stil LOCKED ! !");
		
		return "UnlockEmployeeAccount";
	}

}
