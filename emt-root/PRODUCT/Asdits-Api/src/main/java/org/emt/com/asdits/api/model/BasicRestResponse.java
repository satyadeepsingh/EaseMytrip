package org.emt.com.asdits.api.model;

import com.fasterxml.jackson.annotation.JsonGetter;

public class BasicRestResponse {
	
	protected String errorCode;
	
	protected String message;
	
	@JsonGetter("errorCode")
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	@JsonGetter("message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
