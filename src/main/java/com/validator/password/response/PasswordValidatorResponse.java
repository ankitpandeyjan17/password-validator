package com.validator.password.response;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidatorResponse {
	
	private boolean success;
	private List<String> errorMessages;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<String> getErrorMessages() {
		if(errorMessages == null) {
			errorMessages = new ArrayList<String>();
		}
		return errorMessages;
	}
	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	
}
