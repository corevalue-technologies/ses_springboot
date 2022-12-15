package ses.common;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ses.entity.dto.EmailTemplate;
import ses.entity.dto.Recipient;
import ses.exception.GenericServiceException;
import ses.service.MailSenderService;

/**
 * The Class EmailHelper.
 */
@Service
public class EmailHelper {

	/** The mail sender service using Ses */
	 @Autowired
	 private MailSenderService mailSenderService;

	

	public Boolean sendCreationEmail(String subject, String recipient, MultipartFile doc, String body,
			String senderEmail) throws GenericServiceException, MessagingException, IOException {

		final EmailTemplate email = new EmailTemplate(subject, body, new Recipient(recipient, senderEmail));
		if (doc != null) {
			email.setAddAttachment(true);
			email.setAttachment(doc.getBytes());
		} else {
			throw new GenericServiceException("Attachment is null.", HttpStatus.BAD_REQUEST);
		}
		// sesv2
		return mailSenderService.sendMail(email);

	}
}
