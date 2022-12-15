package ses.entity.dto;

import java.util.Arrays;

/**
 * The Class EmailTemplate.
 */
public class EmailTemplate {

	/** The subject. */
	private String subject;

	/** The body. */
	private String body;

	/** The recipient. */
	private Recipient recipient;

	/** The add attachment. */
	private boolean addAttachment;

	/** The attachment file path. */
	private byte[] attachment;

	/**
	 * Instantiates a new email template.
	 *
	 * @param subject the subject
	 * @param body    the body
	 */
	public EmailTemplate(String subject, String body) {
		this.subject = subject;
		this.body = body;
	}

	/**
	 * Instantiates a new email template.
	 *
	 * @param subject   the subject
	 * @param body      the body
	 * @param recipient the recipient
	 */
	public EmailTemplate(String subject, String body, Recipient recipient) {
		this.subject = subject;
		this.body = body;
		this.recipient = recipient;
	}

	/**
	 * Instantiates a new email template.
	 */
	public EmailTemplate() {
	}

	/**
	 * Gets the subject.
	 *
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 *
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Gets the body.
	 *
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Sets the body.
	 *
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * Gets the recipient.
	 *
	 * @return the recipient
	 */
	public Recipient getRecipient() {
		return recipient;
	}

	/**
	 * Sets the recipient.
	 *
	 * @param recipient the new recipient
	 */
	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}

	/**
	 * Checks if is adds the attachment.
	 *
	 * @return true, if is adds the attachment
	 */
	public boolean isAddAttachment() {
		return addAttachment;
	}

	/**
	 * Sets the adds the k.
	 *
	 * @param addAttachment the new adds the attachment
	 */
	public void setAddAttachment(boolean addAttachment) {
		this.addAttachment = addAttachment;
	}

	/**
	 * Gets the attachment.
	 *
	 * @return the attachment
	 */
	public byte[] getAttachment() {
		return attachment;
	}

	/**
	 * Sets the attachment.
	 *
	 * @param attachment the new attachment
	 */
	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmailTemplate [subject=" + subject + ", body=" + body + ", recipient=" + recipient + ", addAttachment="
				+ addAttachment + ", attachment=" + Arrays.toString(attachment) + "]";
	}

}
