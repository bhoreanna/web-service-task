package com.webkryptominds.webservicetask.modules.security.modules.usermaster;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository

public interface UserMasterRepository extends CrudRepository<UserMaster , BigDecimal>{

	public UserMaster findByUserId(String userId); 
	public UserMaster findByUserName(String userName); 

}
