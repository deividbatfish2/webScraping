package util.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import util.Manipulador;

public class JavaMailApp {

	private Properties props;
	private String mensagem;

	public JavaMailApp() {
		this.props = new Properties();
		/** Par�metros de conex�o com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		this.mensagem = "";
	}

	public void setMensagem(String mensagem) {
		this.mensagem += mensagem + "\n";
	}

	public void enviarEmail(String assunto, String emails) {

		Session session = Session.getDefaultInstance(this.props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("deivid.de.assis.teixeira@gmail.com",
						Manipulador.getProp().getProperty("prop.googleMailKey").toString());
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("deivid.de.assis.teixeira@gmail.com")); // Remetente

			Address[] toUser = InternetAddress // Destinat�rio(s)
					.parse(emails);
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Vagas coletadas _-_ " + assunto);// Assunto
			message.setText(this.mensagem);
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);
			System.out.println("Feito!!!");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * Altere os seguintes campos: �seuemail@gmail.com� para a sua conta do
	 * Gmail,
	 * 
	 * �suasenha123� utilizando a senha da sua conta.
	 * 
	 * E adicione o endere�o do destinat�rio no m�todo .parse
	 * 
	 * Address[] toUser = InternetAddress.parse(��);
	 * 
	 * Pronto! � s� compilar! Email enviado com sucesso!!!
	 */
}
