package org.cardenete.exceptions;

public class NotAuthException extends RuntimeException{
	public NotAuthException(String message) {
		super(message);
	}
}
