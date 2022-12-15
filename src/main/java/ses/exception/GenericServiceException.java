/**
 *
 */
package ses.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

/**
 * The Class GenericServiceException.
 *
 * @author pranci.saxena
 */
public class GenericServiceException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5613318129644079762L;

	/** The id. */
	private String id;

	/** The time stamp. */
	private ZonedDateTime timeStamp;

	/** The status code. */
	private HttpStatus statusCode;

	/** The exception code. */
	private ExceptionCode exceptionCode;

	/** The data. */
	private Map<String, Object> data;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Gets the time stamp.
	 *
	 * @return the timeStamp
	 */
	public ZonedDateTime getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Sets the time stamp.
	 *
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(final ZonedDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the statusCode
	 */
	public HttpStatus getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(final HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the exception code.
	 *
	 * @return the exceptionCode
	 */
	public ExceptionCode getExceptionCode() {
		return exceptionCode;
	}

	/**
	 * Sets the exception code.
	 *
	 * @param exceptionCode the exceptionCode to set
	 */
	public void setExceptionCode(final ExceptionCode exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	/**
	 * @return the data
	 */
	public Map<String, Object> getData() {
		return data;
	}

	/**
	 * Instantiates a new generic service exception.
	 *
	 * @param message       the message
	 * @param cause         the cause
	 * @param exceptionCode the exception code
	 * @param status        the status
	 */
	public GenericServiceException(final String message, final Throwable cause, final ExceptionCode exceptionCode,
			final HttpStatus status) {
		super(message, cause);
		this.exceptionCode = exceptionCode;
		statusCode = status;
		addCommonFields();
	}

	/**
	 * Instantiates a new generic service exception.
	 *
	 * @param message       the message
	 * @param exceptionCode the exception code
	 * @param status        the status
	 */
	public GenericServiceException(final String message, final ExceptionCode exceptionCode, final HttpStatus status) {
		super(message);
		this.exceptionCode = exceptionCode;
		statusCode = status;
		addCommonFields();
	}

	/**
	 * Instantiates a new generic service exception.
	 *
	 * @param message the message
	 */
	public GenericServiceException(final String message) {
		super(message);
		addCommonFields();
	}

	/**
	 * Instantiates a new generic service exception.
	 *
	 * @param message the message
	 * @param status  the status
	 */
	public GenericServiceException(final String message, final HttpStatus status) {
		super(message);
		statusCode = status;
		addCommonFields();
	}

	/**
	 * Instantiates a new generic service exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 * @param status  the status
	 */
	public GenericServiceException(final String message, final Throwable cause, final HttpStatus status) {
		super(message, cause);
		statusCode = status;
		addCommonFields();
	}

	/**
	 * Instantiates a new generic service exception.
	 *
	 * @param exceptionCode the exception code
	 * @param statusCode    the status code
	 */
	public GenericServiceException(final ExceptionCode exceptionCode, final HttpStatus statusCode) {
		this(exceptionCode.getMessage(), exceptionCode, statusCode);
	}

	/**
	 * Instantiates a new generic service exception.
	 *
	 * @param message       the message
	 * @param exceptionCode the exception code
	 * @param statusCode    the status code
	 * @param data          the data
	 */
	public GenericServiceException(final String message, final ExceptionCode exceptionCode, final HttpStatus statusCode,
			final Map<String, Object> data) {
		super(message);
		addCommonFields();
		this.statusCode = statusCode;
		this.exceptionCode = exceptionCode;
		this.data = data;
	}

	/**
	 * Instantiates a new generic service exception.
	 */
	public GenericServiceException() {
		statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	/**
	 * Adds the fields.
	 */
	private void addCommonFields() {
		timeStamp = ZonedDateTime.now(ZoneId.of("UTC"));

	}

}
