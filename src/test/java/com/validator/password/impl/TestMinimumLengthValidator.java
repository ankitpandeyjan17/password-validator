package com.validator.password.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.validator.password.PasswordValidator;
import com.validator.password.exception.ValidationException;

class TestMinimumLengthValidator {

	PasswordValidator minimumLengthValidator = new MinimumLengthValidator();

	@Test
	void testShouldValidateMinimumLengthWhenStringIsNull() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			minimumLengthValidator.validate(null);
		});
		String expectedMessage = "Password should be greater than 8 charaters";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testShouldValidateMinimumLengthWhenStringLengthIsLessThanEight() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			minimumLengthValidator.validate("pwd");
		});
		String expectedMessage = "Password should be greater than 8 charaters";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testShouldValidateMinimumLengthWhenStringLengthIsEqualToEight() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			minimumLengthValidator.validate("password");
		});
		String expectedMessage = "Password should be greater than 8 charaters";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testShouldValidateMinimumLengthWhenStringLengthIsGreatherThanEight() throws ValidationException {
		assertTrue(minimumLengthValidator.validate("validated"));
	}
}
