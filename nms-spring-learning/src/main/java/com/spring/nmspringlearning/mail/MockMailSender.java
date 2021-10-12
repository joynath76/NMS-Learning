package com.spring.nmspringlearning.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class MockMailSender implements MailSender{
	
	private static Log log = LogFactory.getLog(MockMailSender.class);
	
	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending MOCK mail "+to);
		log.info("With subject "+subject);
		log.info("and body "+body);
	}
}
