package org.emt.com.asdits.db.dao;

import javax.transaction.Transactional;

import org.emt.com.asdits.db.entities.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRoleDao extends CrudRepository<UserRole, String> {

}
