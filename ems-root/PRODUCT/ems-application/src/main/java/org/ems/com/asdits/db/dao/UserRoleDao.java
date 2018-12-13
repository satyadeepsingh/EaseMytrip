package org.ems.com.asdits.db.dao;

import javax.transaction.Transactional;

import org.ems.com.asdits.db.entities.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRoleDao extends CrudRepository<UserRole, String> {

}
