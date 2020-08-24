package com.bit.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.bit.model.EmployeeModel;
@Component
public class SendEmailUtils {

	@Autowired
	private JavaMailSender mailSender;
	public   boolean SendUnlockMailToEmployee(EmployeeModel empModel) {
		boolean isSend=false;
		try {
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message);
			helper.setSubject("UNLOCK YOUR ACCOUNT");
			helper.setTo(empModel.getEmailId());
			helper.setText(EmailBody(empModel),true);
			mailSender.send(message);
			isSend=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSend;
		
	}
	
	public String EmailBody(EmployeeModel empModel) throws Exception {
		StringBuffer sb=new StringBuffer("");
		FileReader fileReader=new FileReader("UNLOCK_EMAIL_FORMAT.txt");
		BufferedReader br=new BufferedReader(fileReader);
		String line=br.readLine();
		while (line!=null) {
			sb.append(line);
			line=br.readLine();
		}
		br.close();
		String mailBody=sb.toString();
		mailBody=mailBody.replace("{Fname}",empModel.getFirstName());
		mailBody=mailBody.replace("{Lname}",empModel.getLastName());
		mailBody=mailBody.replace("{TempPassword}", empModel.getPassword());
		mailBody=mailBody.replace("{Email}", empModel.getEmailId());
		return mailBody;
	}
}
