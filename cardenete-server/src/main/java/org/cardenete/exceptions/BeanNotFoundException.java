package org.cardenete.exceptions;

public class BeanNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BeanNotFoundException() {
	}

	public BeanNotFoundException(String message) {
		super(message);
	}

	public BeanNotFoundException(Throwable cause) {
		super(cause);
	}

	public BeanNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeanNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
