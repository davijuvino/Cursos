package com.devdojo.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationExceptionDetails extends SuperExceptionMessage {

	private final String fields;
	private final String fieldsMessage;
}
