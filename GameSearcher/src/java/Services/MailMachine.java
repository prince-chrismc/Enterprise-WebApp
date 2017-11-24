/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author cmcarthur
 */
public class MailMachine {
    private static final MailMachine mailer = new MailMachine();
    
    private final String username = "soen387test2@gmail.com";
    private final String password = "testing1";
    private Properties props;
    private Session session;
    
    private MailMachine() {
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    public void sendMessage(String user_email, String subject, String msg) {
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user_email));
            message.setSubject(subject);
            message.setText(msg);

            Transport.send(message);

            System.out.println("Mail Sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static MailMachine getInstance() { 
        return mailer; 
    }
}
