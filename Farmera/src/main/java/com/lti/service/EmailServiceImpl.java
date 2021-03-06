package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.lti.entity.Bidder;
import com.lti.entity.Farmer;
import com.lti.entity.SellRequest;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private MailSender mailSender;
	
	@Override
	public void sendMailForNewFarmerRegisteration(Farmer farmer) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("mygladproject@outlook.com");
		message.setTo(farmer.getEmailId());
		message.setSubject("Registration complete!");
		message.setText("Greetings "+farmer.getFullName()+"! You are now registered as Farmer. Welcome to Farmera family!");
		mailSender.send(message);
	}

	@Override
	public void sendMailForNewBidderRegisteration(Bidder bidder) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("mygladproject@outlook.com");
		message.setTo(bidder.getEmailId());
		message.setSubject("Registration complete!");
		message.setText("Greetings "+bidder.getFullName()+"! You are now registered as Bidder. Welcome to Farmera family!");
		mailSender.send(message);
	}
	
	@Override
	public void sendMailForCropSellRequest(SellRequest request) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("mygladproject@outlook.com");
		message.setTo(request.getFarmer().getEmailId());
		message.setSubject("Request placed!");
		message.setText("Thank You for placing your request!");
		mailSender.send(message);
	}
	
	@Override
	public void sendResetLink(String email) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("mygladproject@outlook.com");
		message.setTo(email);
		message.setSubject("Link to reset your password");
		message.setText("Reset your password by clicking HERE");
		mailSender.send(message);
	}

	@Override
	public void sendMailToContactUs(String email) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("mygladproject@outlook.com");
		message.setTo(email);
		message.setSubject("Thanks For Contacting Us");
		message.setText("Your Response has been recorded! We will reach out to you soon.");
		mailSender.send(message);
		
	}
	
	@Override
	public void sendMailForSoldCrop(Farmer farmer) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("mygladproject@outlook.com");
		message.setTo(farmer.getEmailId());
		message.setSubject("Congratulations!");
		message.setText("Your crop has been sold! Login for more details.");
		mailSender.send(message);		
	}
	
	@Override
	public void sendMailForWinningBid(Bidder bidder) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("mygladproject@outlook.com");
		message.setTo(bidder.getEmailId());
		message.setSubject("Congratulations!");
		message.setText("Your bid has been accepted! Login for more details.");
		mailSender.send(message);
	}
	
}
