package com.validator.password.impl;

import com.validator.password.PasswordValidator;
import com.validator.password.enums.PasswordValidatorEnum;
import com.validator.password.exception.ValidationException;

public class MinimumLengthValidator implements PasswordValidator{
	@Override
	public boolean validate(String password) throws ValidationException {
		if(password==null || password.length()<=8) {
			throw new ValidationException(PasswordValidatorEnum.MINIMUMCHECKVALIDATOR.getName(), "Password should be greater than 8 charaters");
		}
		return Boolean.TRUE;
	}



}
