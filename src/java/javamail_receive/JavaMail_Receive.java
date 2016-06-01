
package javamail_receive;

import com.sun.mail.pop3.POP3Store;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;


public class JavaMail_Receive {

    public static void main(String[] args) {

		String pop3Host = "imap.gmail.com";
		String storeType = "imaps";
		String user = "ravi.honey@gmail.com";
		String password = "bujji143";

		try {
			Properties properties = new Properties();
			properties.put("mail.imap.host", pop3Host);
			
                        Session emailSession = Session.getDefaultInstance(properties);

			POP3Store emailStore = (POP3Store)emailSession.getStore(storeType);
			emailStore.connect(pop3Host,user, password);
                        
			Folder emailFolder = emailStore.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
                        

			Message[] messages = emailFolder.getMessages();
                        System.out.println(messages.length);
                        byte[] b;
                        int j=0;
			for (int i = messages.length-1; i >=0;i--) {
				Message message = messages[i];
				System.out.println("\n\n======================================");
				System.out.println("Email   : " + j++);
				System.out.println("Date    : " + message.getSentDate());
				System.out.println("Subject : " + message.getSubject());
				System.out.println("From    : " + message.getFrom()[0]);
				System.out.println("Content    : " + message.getContent().toString());
                                if(j==10)
                                {
                                    break;
                                    
                                }
				
			}
                        
                        System.out.println("\n\n======================================");
                        System.out.println("Folder Names");
                        
                        Folder emailFolders[]=emailStore.getDefaultFolder().list();
                        for(int i=0;i<emailFolders.length;i++)
                        {
                            System.out.println(emailFolders[i].getName());
                        }

			emailFolder.close(false);
			emailStore.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
