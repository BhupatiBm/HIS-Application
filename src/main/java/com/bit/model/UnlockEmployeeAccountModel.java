package com.bit.model;

import lombok.Data;

@Data
public class UnlockEmployeeAccountModel{
	public String emailId;
	public String temporaryPassword;
	public String newPassword;
	public String confirmPassword;
}
