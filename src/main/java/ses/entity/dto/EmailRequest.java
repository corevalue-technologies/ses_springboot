package ses.entity.dto;

import java.util.List;

/**
 * The Class Recipient.
 */
public class EmailRequest {

	/** The cc recipient. */
	private List<String> ccRecipient;

	/** The bcc recipient. */
	private List<String> bccRecipient;

	/** The to recipient. */
	private List<String> toRecipient;

	/** The from address. */
	private String fromAddress;


	/**
	 * Gets the from address.
	 *
	 * @return the from address
	 */
	public String getFromAddress() {
		return fromAddress;
	}

	/**
	 * Sets the from address.
	 *
	 * @param fromAddress the new from address
	 */
	public void setFromAddress(final String fromAddress) {
		this.fromAddress = fromAddress;
	}

	/**
	 * Gets the cc recipient.
	 *
	 * @return the cc recipient
	 */
	public List<String> getCcRecipient() {
		return ccRecipient;
	}

	/**
	 * Sets the cc recipient.
	 *
	 * @param ccRecipient the new cc recipient
	 */
	public void setCcRecipient(final List<String> ccRecipient) {
		this.ccRecipient = ccRecipient;
	}

	/**
	 * Gets the bcc recipient.
	 *
	 * @return the bcc recipient
	 */
	public List<String> getBccRecipient() {
		return bccRecipient;
	}

	/**
	 * Sets the bcc recipient.
	 *
	 * @param bccRecipient the new bcc recipient
	 */
	public void setBccRecipient(final List<String> bccRecipient) {
		this.bccRecipient = bccRecipient;
	}

	/**
	 * Gets the to recipient.
	 *
	 * @return the to recipient
	 */
	public List<String> getToRecipient() {
		return toRecipient;
	}

	/**
	 * Sets the to recipient.
	 *
	 * @param toRecipient the new to recipient
	 */
	public void setToRecipient(final List<String> toRecipient) {
		this.toRecipient = toRecipient;
	}

	/**
	 * Instantiates a new recipient.
	 */
	public EmailRequest() {
		super();
	}

	/**
	 * Instantiates a new recipient.
	 *
	 * @param ccRecipient  the cc recipient
	 * @param bccRecipient the bcc recipient
	 * @param toRecipient  the to recipient
	 */
	public EmailRequest(final List<String> ccRecipient, final List<String> bccRecipient, final List<String> toRecipient) {
		super();
		this.ccRecipient = ccRecipient;
		this.bccRecipient = bccRecipient;
		this.toRecipient = toRecipient;
	}

	/**
	 * Instantiates a new recipient.
	 *
	 * @param toRecipient the to recipient
	 * @param fromAddress the from address
	 */
	public EmailRequest(final List<String> toRecipient, final String fromAddress) {
		super();
		this.toRecipient = toRecipient;
		this.fromAddress = fromAddress;

	}


	/**
	 * Instantiates a new recipient.
	 *
	 * @param toRecipient the to recipient
	 */
	public EmailRequest(final List<String> toRecipient) {
		this.toRecipient = toRecipient;
	}

}
