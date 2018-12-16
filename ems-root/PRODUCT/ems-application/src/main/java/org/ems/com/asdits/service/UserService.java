package org.ems.com.asdits.service;

import org.ems.com.asdits.db.dao.LoginDao;
import org.ems.com.asdits.db.dao.UserRoleDao;
import org.ems.com.asdits.db.dao.UsersDao;
import org.ems.com.asdits.db.entities.Login;
import org.ems.com.asdits.db.entities.User;
import org.ems.com.asdits.db.entities.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ems.com.asdits.api.model.CreateUserRequest;
import org.ems.com.asdits.api.model.CreateUserResponse;
import org.ems.com.asdits.api.model.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UsersDao userDao;

	@Autowired
	private LoginDao loginDao;

	@Autowired
	private UserRoleDao userRoleDao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public CreateUserResponse createUser(CreateUserRequest request) {
		
		logger.info("User Creation:{}" + request);
		String password = encoder.encode(request.getPassword());
//		String password = request.getPassword();
		Login login = new Login(request.getUsername(), password);
		this.loginDao.save(login);
		
		UserRole role = new UserRole("USER");
		role.setLogin(login);
		userRoleDao.save(role);

		UserAddress address = request.getAddress();
		User user = new User(request.getName(), login, address.getAddress1(), address.getAddress2(),
				address.getPincode(), address.getCity(), address.getState(), address.getCountry(), request.getEmail());
		this.userDao.save(user);
		CreateUserResponse response = new CreateUserResponse();
		response.setStatusMessage(CreateUserResponse.status.CREATION_SUCCESSFUL.getMessage());

		return response;
	}

}
