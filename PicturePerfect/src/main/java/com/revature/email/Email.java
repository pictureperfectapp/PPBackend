package com.revature.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	public static void sendEmail(String address) throws Exception{
		  
	    final String FROM = "achumchal@gmail.com";
	    final String FROMNAME = "Aaron Chumchal";
	    final String TO = address;
	    final String SMTP_USERNAME = "AKIAUIGEOUVUG2KHXXAT";
	    final String SMTP_PASSWORD = "BHxmY91N+7U5S/DYLcrGmMrrF/2BjGAmLBjL5NIryueu";
	    final String HOST = "email-smtp.us-east-1.amazonaws.com";
	    final int PORT = 587;
	    
	    final String SUBJECT = "Amazon SES test (SMTP interface accessed using Java)";
	    
	   final String BODY = String.join(
	    	    System.getProperty("line.separator"),
	    	    "<h1>Picture Perfect</h1>",
	    	    "<p>It is your turn to play!</p>"
	    	);
	   
   	Properties props = System.getProperties();
   	props.put("mail.transport.protocol", "smtp");
   	props.put("mail.smtp.port", PORT); 
   	props.put("mail.smtp.starttls.enable", "true");
   	props.put("mail.smtp.auth", "true");

       // Create a Session object to represent a mail session with the specified properties. 
   	Session session = Session.getDefaultInstance(props);

       // Create a message with the specified information. 
       MimeMessage msg = new MimeMessage(session);
       msg.setFrom(new InternetAddress(FROM,FROMNAME));
       msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
       msg.setSubject(SUBJECT);
       msg.setContent(BODY,"text/html");
       
      
       Transport transport = session.getTransport();
                   
       // Send the message.
       try
       {
           System.out.println("Sending...");
           
           // Connect to Amazon SES using the SMTP username and password you specified above.
           transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
       	
           // Send the email.
           transport.sendMessage(msg, msg.getAllRecipients());
           System.out.println("Email sent!");
       }
       catch (Exception ex) {
           System.out.println("The email was not sent.");
           System.out.println("Error message: " + ex.getMessage());
       }
       finally
       {
           // Close and terminate the connection.
           transport.close();
       }
	   
	   
	}
}
