package com.validator.password.impl;

import com.validator.password.PasswordValidator;
import com.validator.password.enums.PasswordValidatorEnum;
import com.validator.password.exception.ValidationException;

public class NumericValidator implements PasswordValidator{



	@Override
	public boolean validate(String password) throws ValidationException {
		
		if(password==null || ! password.matches("(.*[0-9].*)")) {
			throw new ValidationException(PasswordValidatorEnum.NUMERICVALIDATOR.getName(), "Password must have atleast one numeric character");
		}
		return Boolean.TRUE;
	}



}
