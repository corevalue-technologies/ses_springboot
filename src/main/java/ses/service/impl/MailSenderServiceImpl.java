package ses.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.RawMessage;
import com.amazonaws.services.simpleemail.model.SendRawEmailRequest;

import ses.entity.dto.EmailTemplate;
import ses.exception.GenericServiceException;
import ses.service.MailSenderService;

/**
 * The Class MailSenderServiceImpl.
 */
@Deprecated
@Service
public class MailSenderServiceImpl implements MailSenderService {

	private static final Log logger = LogFactory.getLog(MailSenderServiceImpl.class);

	/** The Constant UTF_8. */
	private static final String UTF_8 = "UTF-8";

	/** The amazon simple email service. */
	@Autowired
	private AmazonSimpleEmailService amazonSimpleEmailService;

	/**
	 * Send mail.
	 *
	 * @param emailTemplate the email template
	 * @param name          the name
	 * @throws MessagingException      the messaging exception
	 * @throws GenericServiceException the generic service exception
	 */
	@Override
	public Boolean sendMail(final EmailTemplate emailTemplate)
			throws MessagingException, GenericServiceException {
		logger.info("Email details : " + emailTemplate.toString());

		Session session = Session.getInstance(new Properties(System.getProperties()));
		MimeMessage mimeMessage = new MimeMessage(session);
		try {
			mimeMessage.setSubject(emailTemplate.getSubject(), UTF_8);
			mimeMessage.setFrom(emailTemplate.getRecipient().getFromAddress());

			String recipient = emailTemplate.getRecipient().getToRecipient();
			Address toAddress = new InternetAddress(recipient);
			mimeMessage.addRecipient(RecipientType.TO, toAddress);

			MimeMultipart msgBody = new MimeMultipart("alternative");
			MimeBodyPart wrap = new MimeBodyPart();
			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(emailTemplate.getBody(), "text/html; charset=UTF-8");
			msgBody.addBodyPart(htmlPart);
			wrap.setContent(msgBody);

			MimeMultipart msg = new MimeMultipart("mixed");
			mimeMessage.setContent(msg);
			msg.addBodyPart(wrap);

			// Attachment pdf file
			if (emailTemplate.isAddAttachment()) {

				File file = new File("doc");
				OutputStream os = new FileOutputStream(file);
				// Starts writing the bytes in it
				os.write(emailTemplate.getAttachment());
				// Close the file
				os.close();

				MimeBodyPart att = new MimeBodyPart();
				DataSource fds = new FileDataSource(file);
				att.setDataHandler(new DataHandler(fds));
				att.setFileName(fds.getName());
				// Add the attachment to the message.
				msg.addBodyPart(att);
			}
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			mimeMessage.writeTo(outputStream);
			RawMessage rawMessage = new RawMessage(ByteBuffer.wrap(outputStream.toByteArray()));

			// send Mail
			SendRawEmailRequest rawEmailRequest = new SendRawEmailRequest(rawMessage);
			amazonSimpleEmailService.sendRawEmail(rawEmailRequest);
			logger.info("Email sent!");

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Email not sent!");
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
