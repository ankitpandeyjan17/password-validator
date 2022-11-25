package com.validator.password.impl;

import com.validator.password.PasswordValidator;
import com.validator.password.enums.PasswordValidatorEnum;
import com.validator.password.exception.ValidationException;

public class UpperCaseValidator implements PasswordValidator{



	@Override
	public boolean validate(String password) throws ValidationException {
		
		if(password==null || !password.matches("(.*[A-Z].*)")) {
			throw new ValidationException(PasswordValidatorEnum.NULLCHECKVALIDATOR.getName(), "Password must contain atleast one upper case character");
		}
		return Boolean.TRUE;
	}



}
