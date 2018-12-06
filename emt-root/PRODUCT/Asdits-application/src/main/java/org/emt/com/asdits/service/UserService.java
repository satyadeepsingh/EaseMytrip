package org.emt.com.asdits.service;

import org.emt.com.asdits.api.model.CreateUserRequest;
import org.emt.com.asdits.api.model.CreateUserResponse;
import org.emt.com.asdits.api.model.UserAddress;
import org.emt.com.asdits.db.dao.LoginDao;
import org.emt.com.asdits.db.dao.UserRoleDao;
import org.emt.com.asdits.db.dao.UsersDao;
import org.emt.com.asdits.db.entities.Login;
import org.emt.com.asdits.db.entities.User;
import org.emt.com.asdits.db.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UsersDao userDao;

	@Autowired
	private LoginDao loginDao;

	@Autowired
	private UserRoleDao userRoleDao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public CreateUserResponse createUser(CreateUserRequest request) {

		String password = encoder.encode(request.getPassword());
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
