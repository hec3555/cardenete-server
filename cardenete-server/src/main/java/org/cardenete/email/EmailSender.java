package org.cardenete.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.cardenete.entity.UsuarioBean;
import org.cardenete.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {
	
	@Autowired
    public JavaMailSender emailSender;
	
	@Autowired
	private LoginService loginService;
	
	public void sendVerificationEmail(UsuarioBean oUsuario) throws MessagingException {
		
		String token = loginService.getUserToken(oUsuario.getLogin(), oUsuario.getPass());
		
		try {
			MimeMessage mimeMessage = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
			String cuerpo = ""
					+ "<p>"
						+ "<img src=\"http://repositorio.turismocastillalamancha.com/miscelanea/173603/36/e2a9/cardenete.jpg\" width=\"500px\">"
					+ "</p>"
					+ "<p>&iexcl;Gracias por utilizar la aplicaci&oacute;n web de Cardenete!</p>"
					+ "<p>Para poder continuar, debes confirmar tu cuenta haciendo clic en el siguiente enlace:</p>"
					+ "<p>"
						+ "<a href=\"http://localhost:4200/webapp/confirmar-cuenta/"+oUsuario.getLogin()+"/"+token+"\">Confirma tu cuenta</a>"
					+ "</p>";
			mimeMessage.setContent(cuerpo, "text/html");
			helper.setTo(oUsuario.getEmail());
			
			// para probar lo mando a mi correo
			// helper.setTo("hec3555@gmail.com");
			helper.setSubject("CARDENETE: Confirme su dirección de correo electrónico");
			emailSender.send(mimeMessage);
		} catch (MessagingException ex) {
			throw new MessagingException();
		}
		
	}
	
}
