package com.quizmanager.utill;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
public class MailServiceImpl {

	@Autowired
	JavaMailSender mailSender;

	public void sendEmail(String email, String otp) {
		MimeMessagePreparator preparator = getMessagePreparator(email, otp);
		try {
			mailSender.send(preparator);
		} catch (MailException ex) {
			throw new NullPointerException("mail not sent");
		}
	}

	private MimeMessagePreparator getMessagePreparator(final String email,String otp) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom("QuizManager@services");
				mimeMessage.setRecipient(Message.RecipientType.TO,
						new InternetAddress(email));
				mimeMessage.setText("Dear Your OTP is" +otp);
				mimeMessage.setSubject("Quiz Manager OTP");
			}
		};
		return preparator;
	}
}
