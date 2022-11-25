package com.validator.password.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.validator.password.PasswordValidator;
import com.validator.password.exception.ValidationException;

class TestNumericValidator {

	PasswordValidator numericValidator = new NumericValidator();
	
	@Test
	void testShouldValidateWhenStringIsNull() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			numericValidator.validate(null);
		});
		String expectedMessage = "Password must have atleast one numeric character";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void testShouldValidateWhenStringContainNumericCharacter() {
		try {
			assertTrue(numericValidator.validate("Password123"));
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testShouldValidateWhenStringDoesNotContainNumericCharacter() {
		Exception exception = assertThrows(ValidationException.class, () -> {
			numericValidator.validate("password");
		});
		String expectedMessage = "Password must have atleast one numeric character";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

}
