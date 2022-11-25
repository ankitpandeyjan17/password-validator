package com.validator.password;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.validator.password.enums.PasswordValidatorEnum;
import com.validator.password.enums.PasswordValidatorFeature;
import com.validator.password.exception.ValidationException;
import com.validator.password.impl.LowerCaseValidator;
import com.validator.password.impl.MinimumLengthValidator;
import com.validator.password.impl.NullCheckValidator;
import com.validator.password.impl.NumericValidator;
import com.validator.password.impl.UpperCaseValidator;
import com.validator.password.response.PasswordValidatorResponse;

public class PasswordUtility {

	// to store all validator
	List<PasswordValidator> listOfValidator = new ArrayList<>();

	// to store the feature mentioned in the use case
	// minimum validation feature
	// lower case mandatory feature
	Map<PasswordValidatorFeature, Boolean> featureMap;

	public PasswordUtility() {
		// initialize all the validator for the validation of password at the time
		listOfValidator.add(new NullCheckValidator());
		listOfValidator.add(new MinimumLengthValidator());
		listOfValidator.add(new NumericValidator());
		listOfValidator.add(new LowerCaseValidator());
		listOfValidator.add(new UpperCaseValidator());

	}

	// method to validate password
	public PasswordValidatorResponse validatePassword(String password) {

		// variable to track the count number of validation passed
		int passValidatorCount = 0;
		// Store response and send it to client
		PasswordValidatorResponse passwordValidatorResponse = new PasswordValidatorResponse();
		// iterating through all the validator and applying validation logic
		Iterator<PasswordValidator> it = listOfValidator.iterator();
		while (it.hasNext()) {
			try {
				PasswordValidator passwordValidator = it.next();
				passwordValidator.validate(password);
				// if exception occur then count will not get incremented, if count will become
				// equal to validator list size then all validation passed
				passValidatorCount = passValidatorCount + 1;
				if (featureMap != null && !featureMap.isEmpty()) {
					// if feature map contains only minimum validation feature to pass validation
					if (featureMap.containsKey(PasswordValidatorFeature.MINIMUM_VALIDATION)) {
						// minimum validation needs to be executed to pass the validation in current
						// scenario its 3
						// Password is OK if at least three of the previous conditions is true
						if (passValidatorCount == 3) {
							featureMap.put(PasswordValidatorFeature.MINIMUM_VALIDATION, Boolean.TRUE);
							if (featureMap.size() == 1) {
								// if only minimum validation logic need to apply in our case its feature
								break;
							}
						}
					}
				}
			} catch (ValidationException ve) {
				passwordValidatorResponse.getErrorMessages().add(ve.getMessage());
				if (featureMap != null && !featureMap.isEmpty()) {
					//feature if lower case is not there then validation failed
					//password is never OK if item 1.d is not true
					if (featureMap.containsKey(PasswordValidatorFeature.LOWER_CASE)) {
						if (PasswordValidatorEnum.LOWERCASERVALIDATOR.getName().equals(ve.getType())) {
							featureMap.put(PasswordValidatorFeature.LOWER_CASE, Boolean.FALSE);
						}
					}
				}

			}
		}
		//logic if both the feature needs to apply i.e.
		//Password is OK if at least three of the previous conditions 
		////password is never OK if item 1.d is not true
		if (featureMap != null && !featureMap.isEmpty()) {
			Iterator<PasswordValidatorFeature> featureKeySet = featureMap.keySet().iterator();
			passwordValidatorResponse.setSuccess(Boolean.TRUE);

			while (featureKeySet.hasNext()) {
				if (!featureMap.get(featureKeySet.next())) {
					passwordValidatorResponse.setSuccess(Boolean.FALSE);
				}
			}
			resetFeatureMap(featureMap);
		}

		//if count is equal to validator list size then all validation passed
		if (passValidatorCount == listOfValidator.size()) {
			passwordValidatorResponse.setSuccess(Boolean.TRUE);
		}

		return passwordValidatorResponse;
	}

	void addFeature(int featureId) {
		if (featureMap == null) {
			featureMap = new HashMap<>();
		}
		switch (featureId) {
		case 1:
			if (!featureMap.containsKey(PasswordValidatorFeature.MINIMUM_VALIDATION)) {
				featureMap.put(PasswordValidatorFeature.MINIMUM_VALIDATION, Boolean.FALSE);
			}
			break;
		case 2:
			if (!featureMap.containsKey(PasswordValidatorFeature.LOWER_CASE)) {
				featureMap.put(PasswordValidatorFeature.LOWER_CASE, Boolean.TRUE);
			}
			break;
		}

	}

	//reset feature map
	void resetFeatureMap(Map<PasswordValidatorFeature, Boolean> featureMap) {
		if (featureMap.containsKey(PasswordValidatorFeature.MINIMUM_VALIDATION)) {
			featureMap.put(PasswordValidatorFeature.MINIMUM_VALIDATION, Boolean.FALSE);
		}
		if (featureMap.containsKey(PasswordValidatorFeature.LOWER_CASE)) {
			featureMap.put(PasswordValidatorFeature.LOWER_CASE, Boolean.TRUE);
		}

	}
}
