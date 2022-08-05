package com.devdojo.exception;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class SuperExceptionMessage {

	protected String title;
	protected int status;
	protected String message;
	protected String details;
	protected LocalDateTime timestamp;
} 