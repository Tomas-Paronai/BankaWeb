package com.parohyapp.api;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class BankMailSender {
	
	private JavaMailSender mailSender;
	
	public void setMailSender(JavaMailSender mailSender){
		this.mailSender = mailSender;
	}

	public void sendEmail(String email, String subject, String message) {
		SimpleMailMessage mailToSend = new SimpleMailMessage();
		
		mailToSend.setFrom("sovybank@gmail.com");
		mailToSend.setTo(email);
		mailToSend.setSubject(subject);
		mailToSend.setText(message);
		mailSender.send(mailToSend);		
	}
	
	//TODO hash clientID
	public void requestPassword(String email, Integer clientId){		
		String message = "<p>You have requested a new password. Please click the following link to change password.</p><br>"
				+ "<a href='http://localhost:8080/BankaWeb/passwordRequest?client=" + clientId + "'>link</a><br><hr width='20'>"
						+ "<p>Best regards, SovyBank team.</p>";		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			System.out.println("Sending password request email to "+email);
			helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
			mimeMessage.setContent(message, "text/html");
			helper.setTo(email);
			helper.setSubject("New password request");
			helper.setFrom("sovybank@gmail.com");
			mailSender.send(mimeMessage);	
			System.out.println("Success!");
		} catch (MessagingException e) {
			System.out.println("Failed!");
			e.printStackTrace();			
		}		
	}
}
