package org.cardenete.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {
	
	@Autowired
    public JavaMailSender emailSender;
	
	public void sendVerificationEmail(String email) throws MessagingException {
		try {
			MimeMessage mimeMessage = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
			String cuerpo = "Esto es un email de verificación";
			mimeMessage.setContent(cuerpo, "text/html");
			helper.setTo(email);
			helper.setSubject("Confirme su dirección de correo electrónico");
			emailSender.send(mimeMessage);
		} catch (MessagingException ex) {
			throw new MessagingException();
		}
		
	}
	
}
