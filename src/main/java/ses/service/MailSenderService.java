/*
 * Copyright (c) 2019, December Technologies Corporation. All rights reserved.
 *
 * File name: MailSenderService.java
 * Author : akshat.khandpur
 * Creation Date: 13-Dec-2019
 */
package ses.service;

import javax.mail.MessagingException;

import ses.entity.dto.EmailTemplate;
import ses.exception.GenericServiceException;

/**
 * The Interface MailSenderService.
 */
public interface MailSenderService {

	/**
	 * Send mail.
	 *
	 * @param emailTemplate
	 *            the email template
	 * @return 
	 * @throws MessagingException
	 *             the messaging exception
	 * @throws GenericServiceException
	 *             the generic service exception
	 */
	Boolean sendMail(EmailTemplate emailTemplate) throws MessagingException, GenericServiceException;

}
