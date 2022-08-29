package com.ml.register.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodes {

	INTERNAL_SERVER_ERROR("Internal Server Error."),
	ILLEGAL_ARGUMENT_EXCEPTION("Argument not valid."),
	BUSINESS_EXCEPTION("Failure related to a business rule."),
	VALIDATION_FAILED("Validation failed");

	private final String message;
}
