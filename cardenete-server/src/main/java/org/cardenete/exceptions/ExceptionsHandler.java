package org.cardenete.exceptions;

import org.cardenete.entity.ResponseBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

	// Add an exception handler for CustomerNotFoundException
	
	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(BeanNotFoundException exc) {
		
		// create CustomerErrorResponse
		
		ResponseBean error = new ResponseBean(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	// Add another exception handler ... to catch any exception (catch all)

	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(Exception exc) {
		
		// create CustomerErrorResponse
		
		ResponseBean error = new ResponseBean(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}





