package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.lti.entity.Bidder;
import com.lti.entity.Farmer;

@Service
public class EmailService {
	
	@Autowired
	private MailSender mailSender;
	
	public void sendMailForNewFarmerRegisteration(Farmer farmer) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("qwerty.1005@outlook.com");
		message.setReplyTo(farmer.getEmailId());
		message.setSubject("Thank You for Registering with Us!");
		message.setText("Greetings "+farmer.getFullName());
		mailSender.send(message);
	}

	public void sendMailForNewBidderRegisteration(Bidder bidder) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("qwerty.1005@outlook.com");
		message.setReplyTo(bidder.getEmailId());
		message.setSubject("Thank You for Registering with Us!");
		message.setText("Greetings "+bidder.getFullName());
		mailSender.send(message);
	}
	
}
