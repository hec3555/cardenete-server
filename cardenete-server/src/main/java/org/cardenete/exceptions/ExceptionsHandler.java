package org.cardenete.exceptions;

import org.cardenete.entity.ResponseBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

	// Add an exception handler for BeanNotFoundException
	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(BeanNotFoundException exc) {

		// create ErrorResponse
		ResponseBean error = new ResponseBean(HttpStatus.NOT_FOUND.value(), exc.getMessage(),
				System.currentTimeMillis());
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// Add an exception handler for NotAuthException
	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(NotAuthException exc) {

		// create ErrorResponse
		ResponseBean error = new ResponseBean(HttpStatus.UNAUTHORIZED.value(), exc.getMessage(),
				System.currentTimeMillis());
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}

	// Add an exception handler for EmptyListException
	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(EmptyListException exc) {

		// create ErrorResponse
		ResponseBean error = new ResponseBean(HttpStatus.NO_CONTENT.value(), exc.getMessage(),
				System.currentTimeMillis());
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
	}

	// Add an exception handler for NotLoggedException
	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(NotLoggedException exc) {

		// create ErrorResponse
		ResponseBean error = new ResponseBean(HttpStatus.FORBIDDEN.value(), exc.getMessage(),
				System.currentTimeMillis());
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}

	// Add an exception handler for EmailFailedException
	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(EmailFailedException exc) {

		// create ErrorResponse
		ResponseBean error = new ResponseBean(HttpStatus.INTERNAL_SERVER_ERROR.value(), exc.getMessage(),
				System.currentTimeMillis());
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// Add another exception handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(Exception exc) {

		// create CustomerErrorResponse
		ResponseBean error = new ResponseBean(HttpStatus.BAD_REQUEST.value(), exc.getMessage(),
				System.currentTimeMillis());
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
