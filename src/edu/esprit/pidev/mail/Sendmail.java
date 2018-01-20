/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.mail;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author pc
 */
public class Sendmail
{
    Message msg = null ;
    //ico on prpate les varaible s d'etablissemet de connxtion avec le serveur mail (smtp)
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    final String username ;
    final String password ;
    Properties props;
	private String receiver,textemail ;
	Session session;
	public Sendmail(String receiver,String textemail,String username,String password ) {
	 this.receiver=receiver;
	 this.textemail=textemail;
         this.username=username;
         this.password=password;
         props = System.getProperties();
         props.setProperty("mail.smtp.host", "smtp.gmail.com");
	 props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	 props.setProperty("mail.smtp.socketFactory.fallback", "false");
	 props.setProperty("mail.smtp.port", "465");
	 props.setProperty("mail.smtp.socketFactory.port", "465");
	 props.put("mail.smtp.auth", "true");
	 props.put("mail.debug", "true");
	 props.put("mail.store.protocol", "pop3");
	 props.put("mail.transport.protocol", "smtp");		  
	 
	 
	}
        
    // ici c'est la methode de creation de contenue de message a enoyer
    public void send() throws AddressException, MessagingException
    {
        session = Session.getDefaultInstance(props, 
	  new Authenticator(){
	  protected PasswordAuthentication getPasswordAuthentication() {
	  return new PasswordAuthentication(username, password);
	  }});
    	msg = new MimeMessage(session); //
    	MimeBodyPart mbp1 = new MimeBodyPart();
        try {
            //titre de message 
			mbp1.setText("Response!");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        MimeBodyPart mbp2 = new MimeBodyPart();	
         //ici preparation de texte d'email
        mbp2.setText(this.textemail);    
        MimeMultipart mp = new MimeMultipart();
        try {
			mp.addBodyPart(mbp1);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         try {
			mp.addBodyPart(mbp2);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
        msg.setRecipients(Message.RecipientType.TO, 
        InternetAddress.parse(this.receiver,false)); //ici affectation de l'adresse email de distination
        msg.setContent(mp);
        // l"envoie de message 
        Transport.send(msg);
       
    
    }
}
