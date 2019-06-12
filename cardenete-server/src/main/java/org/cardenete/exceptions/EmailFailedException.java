package org.cardenete.exceptions;

public class EmailFailedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailFailedException(String message) {
		super(message);
	}
}
