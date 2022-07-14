package com.devdojo.exception;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ExceptionMessageDetails {

	private String title;
	private int status;
	private String message;
	private String details;
	private LocalDateTime timestamp;
} 