package org.cardenete.exceptions;

public class NotLoggedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotLoggedException(String message) {
		super(message);
	}
}
