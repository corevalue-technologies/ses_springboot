package ses.service.impl;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import ses.common.EmailHelper;
import ses.exception.GenericServiceException;
import ses.service.IService;

/**
 * The Class DocumentServiceImpl.
 */
@Service
public class ServiceImpl implements IService {

	/** The sender email. */
	@Value("${mail.sender.email}")
	private String senderEmail;

	/** The email helper. */
	@Autowired
	EmailHelper emailHelper;

	/**
	 * Email document.
	 *
	 * @param pdfName    the pdf name
	 * @param recipients the recipients
	 * @return the boolean
	 * @throws IOException
	 * @throws MessagingException
	 * @throws GenericServiceException
	 */
	@Override
	public Boolean emailDocument(String subject, String email, String message, MultipartFile doc)
			throws GenericServiceException, MessagingException, IOException {
		if (ObjectUtils.isEmpty(email)) {
			throw new GenericServiceException("No Recipient email found in request!", HttpStatus.BAD_REQUEST);
		}

		// send mail
		return emailHelper.sendCreationEmail(subject, email, doc, message, senderEmail);

	}

}