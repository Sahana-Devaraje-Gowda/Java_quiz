/**
 * 
 */
package com.quizmanager.utill;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.quizmanager.exceptions.UserNotFoundException;

/**
 * @author sahana
 *
 */
@Component
public class ResultsEmailImpl {

	@Autowired
	JavaMailSender mailSender;

	public void sendEmail(String email, String content) {

		MimeMessagePreparator preparator = getMessagePreparator(email, content);

		try {
			mailSender.send(preparator);
		} catch (MailException ex) {
			throw new UserNotFoundException("Error sending email "+ex.toString());
		}
	}

	private MimeMessagePreparator getMessagePreparator(final String email, String content) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom("QuizManager@services");
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				mimeMessage.setText("Dear User " + content);
				mimeMessage.setSubject("Quiz Manager Exam Results");
			}
		};
		return preparator;
	}

}
