package org.ems.com.asdits.controllers;

import java.security.NoSuchAlgorithmException;

import org.ems.com.asdits.action.UserAction;
import org.ems.com.asdits.api.controllers.AbstractApi;
import org.ems.com.asdits.service.UserService;
import org.ems.com.asdits.api.IConstant;
import org.ems.com.asdits.api.model.CreateUserRequest;
import org.ems.com.asdits.api.model.CreateUserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/emt")
public class UserControllerApi10 extends AbstractApi {

	private static final Logger logger = LoggerFactory.getLogger(UserControllerApi10.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, value=IConstant.TEST)
	public ResponseEntity<String> test() {
		logger.info("Hello from get");
		return new ResponseEntity<>("Hello from get", HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.POST, value = IConstant.CREATE_USER, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateUserResponse> createUser(
			@RequestHeader(value = IConstant.X_SESSION_ID_HEADER) String sessionId,
			@RequestBody CreateUserRequest createUserReq) throws NoSuchAlgorithmException {
		logger.info("In controller");

		logger.info(createUserReq.toString());
		ResponseEntity<CreateUserResponse> response = executeRequest(sessionId, new UserAction(this.userService),
				createUserReq);
		logger.info(response.toString());
		return response;
	}

	@Override
	protected Logger getLOGGER() {

		return logger;
	}

}
