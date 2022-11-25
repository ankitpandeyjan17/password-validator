package com.validator.password.exception;

public class ValidationException extends Exception {

	private String type;
	
	public ValidationException() {
		super();
	}

	public ValidationException(String type, String validationMessage) {
		super(validationMessage);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
