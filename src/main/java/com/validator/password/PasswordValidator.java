package com.validator.password;

import com.validator.password.exception.ValidationException;

public interface PasswordValidator {

	boolean validate(String password) throws ValidationException;
}
