package com.validator.password.impl;

import com.validator.password.PasswordValidator;
import com.validator.password.enums.PasswordValidatorEnum;
import com.validator.password.exception.ValidationException;

public class LowerCaseValidator implements PasswordValidator {



	@Override
	public boolean validate(String password) throws ValidationException {
		
		if(password==null || !password.matches("(.*[a-z].*)")) {
			throw new ValidationException(PasswordValidatorEnum.LOWERCASERVALIDATOR.getName(), "Password must have atleast one lower case character.");
		}
		return Boolean.TRUE;
	}



}
