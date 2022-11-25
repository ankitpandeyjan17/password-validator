package com.validator.password.enums;

public enum PasswordValidatorFeature {
	
	MINIMUM_VALIDATION(1),
	LOWER_CASE(3);
	
	private int featureId;

	private PasswordValidatorFeature(int featureId) {
		this.featureId = featureId;
	}

	public int getFeatureId() {
		return featureId;
	}

	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}
}
