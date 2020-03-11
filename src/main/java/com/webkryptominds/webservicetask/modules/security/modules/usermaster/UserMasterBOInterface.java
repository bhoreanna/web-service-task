package com.webkryptominds.webservicetask.modules.security.modules.usermaster;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;



public interface UserMasterBOInterface {

	
	public List<UserMaster> getUserMasterList();
	public UserMaster saveUserMaster(UserMaster userMaster);
	public void saveUserMasterList(List<UserMaster> userMasterList);

	public Optional<UserMaster> searchUserMaster(BigDecimal userUid);
	public int deleteUserMaster(BigDecimal userUid);
	public UserMaster updateUserMaster(UserMaster userMaster);
	public UserMaster findByUserId(String userId); 
	public UserMaster findByUserName(String userName); 

}
