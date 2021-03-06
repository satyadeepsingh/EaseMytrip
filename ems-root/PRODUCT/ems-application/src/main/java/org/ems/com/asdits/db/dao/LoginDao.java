package org.ems.com.asdits.db.dao;

import javax.transaction.Transactional;

import org.ems.com.asdits.db.entities.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface LoginDao extends CrudRepository<Login, String> {
	
	public Login findByUsername(String username);
}
