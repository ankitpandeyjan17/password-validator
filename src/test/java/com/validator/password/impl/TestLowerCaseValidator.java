package com.validator.password.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.validator.password.exception.ValidationException;

class TestLowerCaseValidator {
	
	LowerCaseValidator lowerCaseValidator =new LowerCaseValidator();
	

	@Test
	void testShouldValidateLowerCaseWhenStringIsNull(){
		Exception exception = assertThrows(ValidationException.class, () -> {
			lowerCaseValidator.validate(null);
	    });
	    String expectedMessage = "Password must have atleast one lower case character.";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void testShouldValidateLowerCaseWhenStringNotContainLowerCharacter(){
		Exception exception = assertThrows(ValidationException.class, () -> {
			lowerCaseValidator.validate("PASSWORD");
	    });
	    String expectedMessage = "Password must have atleast one lower case character.";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void testShouldValidateLowerCaseWhenStringContainLowerCharacter() throws ValidationException{
	    assertTrue(lowerCaseValidator.validate("password"));
	}

}
