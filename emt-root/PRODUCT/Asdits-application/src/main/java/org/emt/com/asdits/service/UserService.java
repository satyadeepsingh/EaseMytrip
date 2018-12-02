package org.emt.com.asdits.service;

import java.security.NoSuchAlgorithmException;

import org.emt.com.asdits.api.model.CreateUserRequest;
import org.emt.com.asdits.api.model.CreateUserResponse;
import org.emt.com.asdits.api.model.UserAddress;
import org.emt.com.asdits.db.dao.LoginDao;
import org.emt.com.asdits.db.dao.UsersDao;
import org.emt.com.asdits.db.entities.Login;
import org.emt.com.asdits.db.entities.User;
import org.emt.com.asdits.utils.CryptoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private UsersDao userDao;
	
	@Autowired
	private LoginDao loginDao;

	public CreateUserResponse createUser(CreateUserRequest request) throws NoSuchAlgorithmException {

		String password = CryptoUtils.getDigestHexString(request.getPassword(), CryptoUtils.SHA_256);
		
		Login login = new Login(request.getUsername(), password);
		this.loginDao.save(login);
		UserAddress address = request.getAddress();
		User user = new User(request.getName(), login, address.getAddress1(), address.getAddress2(),
				address.getPincode(), address.getCity(), address.getState(), address.getCountry(),request.getEmail());
		this.userDao.save(user);
		CreateUserResponse response = new CreateUserResponse();
		response.setStatusMessage(CreateUserResponse.status.CREATION_SUCCESSFUL.getMessage());
		
		return response;
	}

}
