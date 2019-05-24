package org.cardenete.exceptions;

public class NotAuthException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotAuthException(String message) {
		super(message);
	}
}
