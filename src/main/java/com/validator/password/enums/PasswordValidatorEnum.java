package com.validator.password.enums;

public enum PasswordValidatorEnum {
	
	MINIMUMCHECKVALIDATOR("lenthcheck"),
	NULLCHECKVALIDATOR("notnull"),
	LOWERCASERVALIDATOR("lowercase"),
	UPPERCASEVALIDATOR("uppercase"),
	NUMERICVALIDATOR("numeric");
	
	private String name;

	private PasswordValidatorEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
