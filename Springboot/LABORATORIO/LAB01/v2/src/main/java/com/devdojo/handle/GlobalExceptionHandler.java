package com.devdojo.handle;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.devdojo.exception.BadRequestException;
import com.devdojo.exception.BadRequestExceptionDetails;
import com.devdojo.exception.SuperExceptionMessage;
import com.devdojo.exception.ValidationExceptionDetails;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	 	@ExceptionHandler(BadRequestException.class)
	    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException e){
	        return new ResponseEntity<>(
	        		BadRequestExceptionDetails.builder()
	                        .timestamp(LocalDateTime.now())
	                        .status(HttpStatus.BAD_REQUEST.value())
	                        .title("Bad Request Exception, Check the Documentation")
	                        .details(e.getMessage())
	                        .message(e.getClass().getName())
	                        .build(), HttpStatus.BAD_REQUEST);
	    }
	 	
	 	
	 	 @Override
	     protected ResponseEntity<Object> handleMethodArgumentNotValid(
	             MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request){
	     
	 		BindingResult result = e.getBindingResult();
	 		List<FieldError> fieldErrors = result.getFieldErrors();
	 		String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
	 		String fieldsMessage = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
	 		
	 		
	 		return new ResponseEntity<>(
	 				ValidationExceptionDetails.builder()
	                        .timestamp(LocalDateTime.now())
	                        .status(HttpStatus.BAD_REQUEST.value())
	                        .title("Bad Request Exception, Invalid Fields")
	                        .details(e.getMessage())
	                        .message(e.getClass().getName())
	                        .fields(fields)
	                        .fieldsMessage(fieldsMessage)
	                        .build(), HttpStatus.BAD_REQUEST);
	    }
	 	
	 	
	 	
	 	@Override
	    protected ResponseEntity<Object> handleExceptionInternal(
	            Exception e, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

			        SuperExceptionMessage superExceptionMessage = SuperExceptionMessage.builder()
			                .timestamp(LocalDateTime.now())
			                .status(status.value())
			                .title(e.getCause().getMessage())
			                .details(e.getMessage())
			                .message(e.getClass().getName())
			                .build();

	        return new ResponseEntity<>(superExceptionMessage, headers, status);
	    }
}
