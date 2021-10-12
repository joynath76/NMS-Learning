package com.spring.nmspringlearning.mail;

public interface MailSender {
	
	void send(String to, String subject, String body);

}
