package com.validator.password.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.validator.password.PasswordValidator;
import com.validator.password.exception.ValidationException;

class TestUpperCaseValidator {

	PasswordValidator upperCaseValidator = new UpperCaseValidator();


	@Test
	void testShouldValidateLowerCaseWhenStringIsNull() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			upperCaseValidator.validate(null);
		});
		String expectedMessage = "Password must contain atleast one upper case character";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testShouldValidateWhenStringContainUpperCharacter() throws ValidationException {
		assertTrue(upperCaseValidator.validate("Password"));
	}

	@Test
	void testShouldValidateLowerCaseWhenStringContainLowerCharacter() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			upperCaseValidator.validate("password");
		});
		String expectedMessage = "Password must contain atleast one upper case character";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

}
