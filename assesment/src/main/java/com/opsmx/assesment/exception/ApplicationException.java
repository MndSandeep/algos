package com.opsmx.assesment.exception;

/**
 * Custom exception class to hold the other exceptions and construct a detailed
 * application level exception with valid error code and readable message.
 * 
 * @author sandeep
 *
 */
public class ApplicationException extends Exception {
	int errorCode;

	/**
	 * 
	 */
	private static final long serialVersionUID = -1699302510293646824L;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

}
