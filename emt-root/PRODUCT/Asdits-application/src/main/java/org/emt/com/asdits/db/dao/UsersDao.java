package org.emt.com.asdits.db.dao;

import org.emt.com.asdits.db.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UsersDao extends CrudRepository<User, String>{
	
}
