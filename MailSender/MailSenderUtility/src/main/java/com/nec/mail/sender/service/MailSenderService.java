package com.nec.mail.sender.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@PostConstruct
	public void sendMail() {
		
		System.out.println("Going to send email");
		
		MimeMessage message = javaMailSender.createMimeMessage();

        try {
        	MimeMessageHelper helper = new MimeMessageHelper(message, false, StandardCharsets.UTF_8.name());
        	helper.setFrom(new InternetAddress("Test", "ALP App"));
        	helper.setTo("92dinesh.here@gmail.com");
            helper.setText("Hello test email", true);
            helper.setSubject("Test Mail");
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
            //return "Error while sending mail ..";
        }
        javaMailSender.send(message);
        System.out.println("Email has been sent");
	}
	
	//@PostConstruct
	public void sendMailWithAttachment() {
		
		System.out.println("Going to send email");
		
		MimeMessage message = javaMailSender.createMimeMessage();

        try {
        	MimeMessageHelper helper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());
        	helper.setFrom(new InternetAddress("Test", "ALP App"));
        	helper.setTo("92dinesh.here@gmail.com");
            helper.setText("Hello test email", true);
            helper.setSubject("Test Mail");
            
            File fileToAttach = new File("/home/dinesh/Desktop/Electricit_bill_Aug_Sep.pdf");
            
            helper.addAttachment(fileToAttach.getName(), new FileSystemResource(fileToAttach));
            
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
            //return "Error while sending mail ..";
        }
        javaMailSender.send(message);
        System.out.println("Email has been sent with attachment");
	}
	
}
