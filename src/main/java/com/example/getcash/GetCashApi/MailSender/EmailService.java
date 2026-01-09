package com.example.getcash.GetCashApi.MailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.getcash.GetCashApi.UtilityHelper.Util;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendOtp(String userName, String toMail) {
		String otpp = Util.generateOtp();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toMail);
		message.setSubject("GetCash Otp Verifications");
		message.setText("Hi " + userName + ",\n\n" + "Your verification farji code  for GetCash is: " + otpp + "\n\n"
				+ "This OTP is valid for 5 minutes.\n" + "Please do not share this code with anyone.\n\n" + "Regards,\n"
				+ "GetCash Team");
		mailSender.send(message);
	}

	public void registerSendOtp(String userName, String toMail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toMail);
		message.setSubject("GetCash Otp Verifications");
		message.setText("Dear " + userName + ",\n\n" + "You have registered successfully on GetCash.\n\n"
				+ "Welcome to GetCash! We are glad to have you with us.\n\n"
				+ "If you did not perform this registration or need any assistance, please contact our support team.\n\n"
				+ "Regards,\n" + "GetCash Team");
		mailSender.send(message);
	}

}
