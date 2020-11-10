package com.selimhorri.app.pack.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.selimhorri.app.pack.exceptions.payloads.ExceptionMsg;

/**
 * @author Selim Horri
 */
@ControllerAdvice
public class ApiHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiHandler.class);
	
	static {
		logger.info("************ entering " + ApiHandler.class.getName() + " ************");
	}
	
	/**
	 * handle all runtime exceptions and try to print a specific Msg for end user through my payload
	 * @param <T>
	 * @param exception
	 * @param webRequest
	 * @return ExceptionMsg instance
	 */
	@ExceptionHandler(
		value = {
			NoSuchElementException.class,
			NumberFormatException.class,
			MethodArgumentTypeMismatchException.class,
			JpaObjectRetrievalFailureException.class, // if a foreign key does not exist...
			// SQLIntegrityConstraintViolationException.class
		}
	)
	public <T extends RuntimeException> ResponseEntity<ExceptionMsg> handleExceptionMsg(final T exception, final WebRequest webRequest) {
		
		final ExceptionMsg exceptionMsg = new ExceptionMsg(exception.getMessage(), HttpStatus.BAD_REQUEST, exception, ZonedDateTime.now(ZoneId.systemDefault()));
		
		System.err.println(exceptionMsg);
		System.err.println(webRequest);
		
		return new ResponseEntity<>(exceptionMsg, exceptionMsg.getHttpStatus());
	}
	
	
	
}











