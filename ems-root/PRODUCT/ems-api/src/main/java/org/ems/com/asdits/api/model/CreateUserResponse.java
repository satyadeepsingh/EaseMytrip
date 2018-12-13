package org.ems.com.asdits.api.model;

import com.fasterxml.jackson.annotation.JsonGetter;

public class CreateUserResponse extends BasicRestResponse {
	
	public enum status {
		CREATION_SUCCESSFUL("user_creation_successful"), CREATION_FAILED("user_creation_failed");
		
		private String message;
		
		private status(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
		
		
	}
	
	private String statusMessage;
	
	@JsonGetter("statusMessage")
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((statusMessage == null) ? 0 : statusMessage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateUserResponse other = (CreateUserResponse) obj;
		if (statusMessage == null) {
			if (other.statusMessage != null)
				return false;
		} else if (!statusMessage.equals(other.statusMessage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreateUserResponse [statusMessage=" + statusMessage + ", errorCode=" + errorCode + ", message="
				+ message + "]";
	}
	
	
	

}
