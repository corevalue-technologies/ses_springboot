package ses.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ses.exception.GenericServiceException;
import ses.service.IService;

/**
 * The Class Controller.
 */
@RestController
public class Controller {

	/** The service. */
	@Autowired
	IService service;

	/**
	 * Email document.
	 *
	 * @param file the file
	 * @param subject the subject
	 * @param email the email
	 * @param message the message
	 * @return the response entity
	 * @throws GenericServiceException the generic service exception
	 * @throws MessagingException the messaging exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@PostMapping("/sendMail")
	public ResponseEntity<Boolean> emailDocument(@RequestParam(name = "file", required = true) MultipartFile file,
			@RequestParam("subject") String subject, @RequestParam("email") String email,
			@RequestParam("message") String message) throws GenericServiceException, MessagingException, IOException {

		Boolean resp = service.emailDocument(subject, email, message, file);
		return new ResponseEntity<>(resp, HttpStatus.OK);

	}

}
