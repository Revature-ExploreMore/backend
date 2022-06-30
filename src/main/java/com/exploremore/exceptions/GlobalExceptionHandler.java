package com.exploremore.exceptions;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	// globally defined handler for any exceptions in the project
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		 Map<String, String> errors = new HashMap<>();
		    ex.getBindingResult().getAllErrors().forEach((error) -> {
		        String fieldName = ((FieldError)error).getField();
		        String errorMessage = error.getDefaultMessage();
		        errors.put(fieldName, errorMessage);
		    });
		    return new ResponseEntity<Object>(errors, headers, status);
	}
	
	@ExceptionHandler({GlobalException.class})
	protected ResponseEntity<Object> handleGlobalException(Exception ex) { 
		 Map<String, String> errors = new HashMap<>();									
		 System.out.println(errors);
		 errors.put("date", LocalDate.now()+"");
		 errors.put("errorMessage", ex.getMessage());
		 System.out.println(errors);
		 return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}



}