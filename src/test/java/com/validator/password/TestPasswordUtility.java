package com.validator.password;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.validator.password.enums.PasswordValidatorFeature;
import com.validator.password.response.PasswordValidatorResponse;

class TestPasswordUtility {

	@Test
	void testShouldCheckFeatureIfAtLeastThreePreviousConditionsAreTrue() {
		PasswordUtility passwordUtility = new PasswordUtility();
		passwordUtility.addFeature(1);
		//checking Not Null which is mandatory and upper case and lower case
		PasswordValidatorResponse passwordValidatorResponse=passwordUtility.validatePassword("MinimumthreeValidation");
		assertTrue(passwordValidatorResponse.isSuccess());
	}
	
	@Test
	void testShouldCheckFeatureIfLowerCaseFeatureIsEnableButLowerCaseCharacterIsNotPresent() {
		PasswordUtility passwordUtility = new PasswordUtility();
		passwordUtility.addFeature(2);
		//checking Not Null which is mandatory and upper case and lower case
		PasswordValidatorResponse passwordValidatorResponse=passwordUtility.validatePassword("LOWERCASEVALIDATION123");
		assertFalse(passwordValidatorResponse.isSuccess());
	}
	
	@Test
	void testShouldCheckFeatureIfLowerCaseFeatureAnDMinimumValidationFeatureIsEnableButLowerCaseCharacterIsNotPresent() {
		PasswordUtility passwordUtility = new PasswordUtility();
		passwordUtility.addFeature(2);
		passwordUtility.addFeature(1);
		PasswordValidatorResponse passwordValidatorResponse=passwordUtility.validatePassword("LOWERCASEVALIDATION123");
		assertFalse(passwordValidatorResponse.isSuccess());
	}
	
	@Test
	void testShouldCheckFeatureIfLowerCaseFeatureAndMinimumValidationFeatureIsEnableAndLowerCaseCharacterIsPresent() {
		PasswordUtility passwordUtility = new PasswordUtility();
		passwordUtility.addFeature(2);
		passwordUtility.addFeature(1);
		PasswordValidatorResponse passwordValidatorResponse=passwordUtility.validatePassword("LOWERcaseVALIDATION123");
		assertTrue(passwordValidatorResponse.isSuccess());
	}
	
	@Test
	void testShouldCheckWhenThePasswordIsPassedAsNullThenAllValidationFailed() {
		PasswordUtility passwordUtility = new PasswordUtility();
		PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword(null);
		assertTrue(passwordValidatorResponse.getErrorMessages().size() == passwordUtility.listOfValidator.size());
	}
	
	
	@Test
	void testShouldCheckWhenThePasswordIsLessThanEightCharacter() {
		PasswordUtility passwordUtility = new PasswordUtility();
		PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword("Passw12");
		assertTrue(passwordValidatorResponse.getErrorMessages().size() == 1);
		assertTrue("Password should be greater than 8 charaters"
				.equals(passwordValidatorResponse.getErrorMessages().get(0)));
	}

	@Test
	void testShouldCheckWhenThePasswordIsEqualToEightCharacter() {
		PasswordUtility passwordUtility = new PasswordUtility();
		PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword("Passw123");
		assertTrue(passwordValidatorResponse.getErrorMessages().size() == 1);
		assertTrue("Password should be greater than 8 charaters"
				.equals(passwordValidatorResponse.getErrorMessages().get(0)));
	}

	@Test
	void testShouldCheckWhenThePasswordIsGreaterEightCharacter() {
		PasswordUtility passwordUtility = new PasswordUtility();
		PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword("Password123");
		assertTrue(passwordValidatorResponse.getErrorMessages().size() == 0);
		assertTrue(passwordValidatorResponse.getErrorMessages().isEmpty());
	}

	@Test
	void testShouldCheckWhenThePasswordNotContainUpperCase() {
		PasswordUtility passwordUtility = new PasswordUtility();
		PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword("password12");
		assertTrue(passwordValidatorResponse.getErrorMessages().size() == 1);
		assertTrue("Password must contain atleast one upper case character"
				.equals(passwordValidatorResponse.getErrorMessages().get(0)));
	}

	@Test
	void testShouldCheckWhenThePasswordContainOneUpperCase() {
		PasswordUtility passwordUtility = new PasswordUtility();
		PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword("Passwo123");
		assertTrue(passwordValidatorResponse.getErrorMessages().size() == 0);
	}

	@Test
	void testShouldCheckWhenThePasswordContainMoreThanOneUpperCase() {
		PasswordUtility passwordUtility = new PasswordUtility();
		PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword("PasswORD123");
		assertTrue(passwordValidatorResponse.getErrorMessages().isEmpty());
	}

	@Test
	void testShouldCheckWhenThePasswordContainZeroLowerCase() {
		PasswordUtility passwordUtility = new PasswordUtility();
		PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword("TEST12345");
		assertTrue(passwordValidatorResponse.getErrorMessages().size() == 1);
		assertTrue("Password must have atleast one lower case character."
				.equals(passwordValidatorResponse.getErrorMessages().get(0)));
	}

	@Test
	void testShouldCheckWhenThePasswordContainOneLowerCase() {
		PasswordUtility passwordUtility = new PasswordUtility();
		PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword("TESt12345");
		assertTrue(passwordValidatorResponse.getErrorMessages().isEmpty());
	}

	@Test
	void testShouldCheckWhenThePasswordContainMoreThanOneLowerCase() {
		PasswordUtility passwordUtility = new PasswordUtility();
		PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword("Test12345");
		assertTrue(passwordValidatorResponse.getErrorMessages().isEmpty());
	}

	@Test
	void testShouldCheckWhenThePasswordContainNoNumericCharacter() {
		PasswordUtility passwordUtility = new PasswordUtility();
		PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword("DigitisnotPresent");
		assertTrue(passwordValidatorResponse.getErrorMessages().size() == 1);
		assertTrue("Password must have atleast one numeric character"
				.equals(passwordValidatorResponse.getErrorMessages().get(0)));
	}

	@Test
	void testShouldCheckWhenThePasswordContainExactlyOneNumericCharacter() {
		PasswordUtility passwordUtility = new PasswordUtility();
		PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword("Digitcheck1");
		assertTrue(passwordValidatorResponse.getErrorMessages().isEmpty());
	}

	@Test
	void testShouldCheckWhenThePasswordContainMoreThanOneNumericCharacter() {
		PasswordUtility passwordUtility = new PasswordUtility();
		PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword("Digit12345");
		assertTrue(passwordValidatorResponse.getErrorMessages().isEmpty());
	}

	@Test
	void testShouldCheckAddFeatureWhenFeatureIdIsOne() {
		PasswordUtility passwordUtility = new PasswordUtility();
		passwordUtility.addFeature(1);
		assertNotNull(passwordUtility.featureMap.get(PasswordValidatorFeature.MINIMUM_VALIDATION));
	}

	@Test
	void testShouldCheckAddFeatureWhenFeatureIdIsTwo() {
		PasswordUtility passwordUtility = new PasswordUtility();
		passwordUtility.addFeature(2);
		assertNotNull(passwordUtility.featureMap.get(PasswordValidatorFeature.LOWER_CASE));
	}

	@Test
	void testShouldCheckAddFeatureWhenFeatureIdIsZeroOrInvalid() {
		PasswordUtility passwordUtility = new PasswordUtility();
		passwordUtility.addFeature(0);
		assertNull(passwordUtility.featureMap.get(PasswordValidatorFeature.LOWER_CASE));
		assertNull(passwordUtility.featureMap.get(PasswordValidatorFeature.MINIMUM_VALIDATION));
	}

	@Test
	void testShouldCheckresetFeatureMapWhenFeatureMapContainsMinimumValidationFeature() {
		PasswordUtility passwordUtility = new PasswordUtility();
		Map<PasswordValidatorFeature, Boolean> featureMap = new HashMap<PasswordValidatorFeature, Boolean>();
		featureMap.put(PasswordValidatorFeature.MINIMUM_VALIDATION, Boolean.TRUE);
		passwordUtility.resetFeatureMap(featureMap);
		assertFalse(featureMap.get(PasswordValidatorFeature.MINIMUM_VALIDATION));
	}

	@Test
	void testShouldCheckresetFeatureMapWhenFeatureMapContainsLowerCaseFeature() {
		PasswordUtility passwordUtility = new PasswordUtility();
		Map<PasswordValidatorFeature, Boolean> featureMap = new HashMap<PasswordValidatorFeature, Boolean>();
		featureMap.put(PasswordValidatorFeature.LOWER_CASE, Boolean.FALSE);
		passwordUtility.resetFeatureMap(featureMap);
		assertTrue(featureMap.get(PasswordValidatorFeature.LOWER_CASE));
	}

}
