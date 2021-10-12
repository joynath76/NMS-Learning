package com.spring.nmspringlearning.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.nmspringlearning.mail.MailSender;

@RestController
public class mailController {

	private MailSender mailSender;
	
	public mailController(MailSender mockMailSender) {
		this.mailSender = mockMailSender;
	}

	@RequestMapping("/mail")
	public String sendMail() {
		
		mailSender.send("jborman76@gmail.com", "test-mail", "Sending mail from spring boot application");
		return "Mail is Sent";
	}
}
