package com.validator.password.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.validator.password.exception.ValidationException;

class TestNullCheckValidator {
	NullCheckValidator nullCheckValidator = new NullCheckValidator();

	@Test
	void testShouldValidateWhenStringIsNull() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			nullCheckValidator.validate(null);
		});
		String expectedMessage = "Password cannot be empty or null.";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testShouldValidateWhenStringIsNotNull() throws ValidationException {
		assertTrue(nullCheckValidator.validate("validated"));
	}

}
