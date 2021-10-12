package com.spring.nmspringlearning.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


public class SmtpMailSender implements MailSender{
	
	private JavaMailSender javaMailSender;
	
	public SmtpMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void send(String to, String subject, String body) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setText(body);
			helper.setSubject(subject);

			javaMailSender.send(message);
		}catch(Exception e) {
			e.getStackTrace();
		}
		
	}
}
