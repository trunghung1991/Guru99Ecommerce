package util;

import java.io.File;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {
	public static void sendMail() {
		// Recipient's email
		String to = "hungnguyen@yopmail.com";

		// Sender's email
		String from = "trunghung9119@gmail.com";

		// Setup gmail smtp host
		String host = "smtp.gmail.com";

		// Get system properties
		Properties prop = System.getProperties();

		// Setup mail server
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.enabled", "true");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		// Get the Session object and pass username and password
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("noisearound91@gmail.com", "trunghung1234");
			}
		});

		try {
			// Create a default MIME Message object
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("This is the subject Line!");

			// Set the actual message
			// message.setText("This is the actual message");

			session.setDebug(true);
			/**
			 * Add attachment to email
			 */
			Multipart multipart = new MimeMultipart();
			MimeBodyPart attachmentPart = new MimeBodyPart();
			MimeBodyPart textPart = new MimeBodyPart();
			try {
				File f = new File("C:\\Users\\hung.nguyen\\Downloads\\TestCase-10.png");
				attachmentPart.attachFile(f);
				textPart.setText("This is text");
				multipart.addBodyPart(textPart);
				multipart.addBodyPart(attachmentPart);
			} catch (Exception e) {
				// TODO: handle exception
			}
			message.setContent(multipart);
			System.out.println("Sending...");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully");

		} catch (AddressException ae) {
			// TODO Auto-generated catch block
			ae.printStackTrace();
		} catch (MessagingException me) {
			// TODO Auto-generated catch block
			me.printStackTrace();
		}
	}
}
