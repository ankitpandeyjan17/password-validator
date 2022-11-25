package com.validator.password.impl;
import com.validator.password.PasswordValidator;
import com.validator.password.enums.PasswordValidatorEnum;
import com.validator.password.exception.ValidationException;

public class NullCheckValidator implements PasswordValidator {

	@Override
	public boolean validate(String password) throws ValidationException {
		
		if(password==null || password.isEmpty()) {
			throw new ValidationException(PasswordValidatorEnum.NULLCHECKVALIDATOR.getName(), "Password cannot be empty or null.");
		}
		return Boolean.TRUE;
	}

}
