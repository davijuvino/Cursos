package com.devdojo.handle;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devdojo.exception.BadRequestException;
import com.devdojo.exception.ExceptionMessageDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(BadRequestException.class)
	    public ResponseEntity<ExceptionMessageDetails> handlerBadRequestException(BadRequestException bre){
	        return new ResponseEntity<>(
	        		ExceptionMessageDetails.builder()
	                        .timestamp(LocalDateTime.now())
	                        .status(HttpStatus.BAD_REQUEST.value())
	                        .title("Bad Request Exception, Check the Documentation")
	                        .details(bre.getMessage())
	                        .message(bre.getClass().getName())
	                        .build(), HttpStatus.BAD_REQUEST);
	    }
}
