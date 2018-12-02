package org.emt.com.asdits.action;

import java.security.NoSuchAlgorithmException;

import org.emt.com.asdits.api.action.ApiAction;
import org.emt.com.asdits.api.model.CreateUserRequest;
import org.emt.com.asdits.api.model.CreateUserResponse;
import org.emt.com.asdits.service.UserService;


public class UserAction implements ApiAction<CreateUserResponse, CreateUserRequest> {
	
	private final UserService userService;
	
	public UserAction(UserService userService) {
		this.userService = userService;
	}
	
	
	public CreateUserResponse execute(CreateUserRequest request) throws NoSuchAlgorithmException {
		return this.userService.createUser(request);
	}

}
