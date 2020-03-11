package com.webkryptominds.webservicetask.modules.security.modules.rolemaster;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface RoleMasterRepository extends CrudRepository<RoleMaster , BigDecimal> {

	public RoleMaster findByRoleId(String roleId); 

}
