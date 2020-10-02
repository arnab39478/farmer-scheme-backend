package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.lti.entity.Bidder;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;

@Service
public class EmailService {
	
	@Autowired
	private MailSender mailSender;
	
	public void sendMailForNewFarmerRegisteration(Farmer farmer) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("mygladproject@outlook.com");
		message.setTo(farmer.getEmailId());
		message.setSubject("Registration complete!");
		message.setText("Greetings "+farmer.getFullName());
		mailSender.send(message);
	}

	public void sendMailForNewBidderRegisteration(Bidder bidder) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("mygladproject@outlook.com");
		message.setTo(bidder.getEmailId());
		message.setSubject("Registration complete!");
		message.setText("Greetings "+bidder.getFullName());
		mailSender.send(message);
	}
	
	public void sendMailForCropSellRequest(SellRequest request) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("mygladproject@outlook.com");
		message.setTo(request.getFarmer().getEmailId());
		message.setSubject("Request placed!");
		message.setText("Thank You for placing your request!");
		mailSender.send(message);
	}
	
	public void sendResetLink(String email) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("mygladproject@outlook.com");
		message.setTo(email);
		message.setSubject("Link to reset your password");
		message.setText("Reset your password by clicking HERE");
		mailSender.send(message);
	}
	
}
