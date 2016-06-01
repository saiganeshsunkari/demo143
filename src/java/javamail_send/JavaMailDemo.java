
package javamail_send;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailDemo {

  
    public static void main(String[] args) {


        //String to = "itg62@miraclesoft.com";
        //String from = "ravisoft08@gmail.com";
        String host = "smtp.gmail.com";   


        Properties properties = new Properties();
        
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.auth", "true");


        Authenticator a = new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {

                return new javax.mail.PasswordAuthentication("saiganeshsunkari38@gmail.com","miracle38");
            }
        };
       

        Session session = Session.getInstance(properties,a);
       
        try {
            MimeMessage mess = new MimeMessage(session);
            
            mess.setFrom(new InternetAddress("saiganeshsunkari38@gmail.com"));
            mess.addRecipient(Message.RecipientType.TO, new InternetAddress("thanusha.nani@gmail.com"));
            mess.setSubject("Java Mail Demo");
            mess.setText("Hello, this is example of sending email ");
             mess.setSentDate(new Date());
         

            Transport.send(mess);
            System.out.println("message sent successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
