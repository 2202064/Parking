package utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailUtility {

    public static void sendMail(String mail, String subject, String content) throws Exception {

	    Properties props = new Properties();
		// SMTPサーバーのアドレスを指定
		props.put("mail.smtp.host", "localhost");
		props.put("mail.host", "localhost");
		props.put("mail.from", "systemadmin@yourparkingdropship.com ");
		Session Ssession = Session.getDefaultInstance(props, null);
		Store store = Ssession.getStore("pop3");
		store.connect("localhost", "admin", "Administrator1");

		try {
			MimeMessage mimeMessage = new MimeMessage(Ssession);
			// 送信元メールアドレスと送信者名を指定
			mimeMessage.setFrom(new InternetAddress("systemadmin@yourparkingdropship.com ", "SanoKouki", "iso-2022-jp"));
			// 送信先メールアドレスを指定
			mimeMessage.setRecipients(Message.RecipientType.TO, mail);
			// メールのタイトルを指定
			mimeMessage.setSubject(subject, "iso-2022-jp");
			// メールの内容を指定
			mimeMessage.setText(content, "iso-2022-jp");
			// メールの形式を指定
			//mimeMessage.setHeader("Content-Type","text/html");
			// 送信日付を指定
			mimeMessage.setSentDate(new Date());
			// 送信します
			Transport.send(mimeMessage);
		} catch (Exception e) {
	        e.printStackTrace();
	        throw new Exception("MailUtil sendEmail failed: " + e.getMessage(), e);
	    }
    }
}
