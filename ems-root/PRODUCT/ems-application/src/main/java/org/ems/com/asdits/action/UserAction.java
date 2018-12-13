package org.ems.com.asdits.action;

import java.security.NoSuchAlgorithmException;

import org.ems.com.asdits.service.UserService;
import org.ems.com.asdits.api.action.ApiAction;
import org.ems.com.asdits.api.model.CreateUserRequest;
import org.ems.com.asdits.api.model.CreateUserResponse;


public class UserAction implements ApiAction<CreateUserResponse, CreateUserRequest> {
	
	private final UserService userService;
	
	public UserAction(UserService userService) {
		this.userService = userService;
	}
	
	
	public CreateUserResponse execute(CreateUserRequest request) throws NoSuchAlgorithmException {
		return this.userService.createUser(request);
	}

}
