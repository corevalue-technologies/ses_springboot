/**
 *
 */
package ses.exception;

/**
 * The Enum ExceptionCode.
 *
 * @author pranci.saxena
 */
public enum ExceptionCode {

	/** The unknown server err. */
	UNKNOWN_SERVER_ERR("Unknown Server Error"),
	
	/** The invalid method params. */
	INVALID_METHOD_PARAMS("Invalid request params"),

	/** The unsupported. */
	UNSUPPORTED("Unsupported operation"),

	/** The not found. */
	NOT_FOUND("Item not found");

	/** The message. */
	private final String message;

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * Instantiates a new exception code.
	 *
	 * @param message the message
	 */
	private ExceptionCode(final String message) {
		this.message = message;
	}

}
