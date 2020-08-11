package com.groovy;


import com.sun.mail.smtp.SMTPTransport;
import com.sun.mail.util.BASE64EncoderStream;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mail {

    private static final String SMTP_SERVER_HOST = "smtp.gmail.com";
    private static final String SMTP_SERVER_PORT = "587";
    private static final String SUBJECT = "Sending mail with Gmail SMTP and Java Mail";
    private static final String BODY = "Hi,<br><br>This is a programmatic email.";


    public static void main(String[] args) {

        final String FROM_USER_EMAIL = "z.murenko@gmail.com";
        final String FROM_USER_FULLNAME = "Evgeniy Murenko";
        final String FROM_USER_ACCESSTOKEN = "dXNlcj16Lm11cmVua29AZ21haWwuY29tXkFhdXRoPUJlYXJlciA3Njk0MTcyMTE4NDEtNnE2YXZuYmNzMzEzbXJ1djFndm9idHF2cmRxMjE0cG0uYXBwcy5nb29nbGV1c2VyY29udGVudC5jb21eQV5B";
        final String TO_USER_EMAIL = "evgeniy.murenko@jevera.software";


        new Mail().sendMail(SMTP_SERVER_HOST, SMTP_SERVER_PORT, FROM_USER_EMAIL, FROM_USER_ACCESSTOKEN, FROM_USER_EMAIL, FROM_USER_FULLNAME, TO_USER_EMAIL, SUBJECT, BODY);
    }


    public void sendMail(String smtpServerHost, String smtpServerPort,  String smtpUserName, String smtpUserAccessToken,
                         String fromUserEmail, String fromUserFullName, String toEmail, String subject, String body) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.ssl.enable", "true"); // required for Gmail
            props.put("mail.smtp.sasl.enable", "true");
            props.put("mail.smtp.sasl.mechanisms", "XOAUTH2");
            props.put("mail.smtp.auth.login.disable", "true");
            props.put("mail.smtp.auth.plain.disable", "true");

            Session session = Session.getInstance(props);
            Transport transport = session.getTransport("smpt");


            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromUserEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            msg.setSubject("JavaMail OAuth2 test");
            msg.setSentDate(new Date());
            msg.setText("Hello, world with OAuth2!\n");
            msg.saveChanges();

            transport.connect("smtp.gmail.com", fromUserFullName, smtpUserAccessToken);
            transport.send(msg, msg.getAllRecipients());

        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }



}
