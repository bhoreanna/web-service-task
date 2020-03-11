package com.webkryptominds.webservicetask.modules.security.modules.usermaster;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service

public class UserMasterService implements UserMasterBOInterface {
	@Autowired
	private UserMasterRepository repository;
	public UserMasterService() {
		
	}
	@Override
	public List<UserMaster> getUserMasterList() {
		return (List<UserMaster>) repository.findAll();
	}
	
	@Override
	public UserMaster saveUserMaster(UserMaster userMaster) {
		 repository.save(userMaster);
		return userMaster;
	}
	@Override
	public Optional<UserMaster> searchUserMaster(BigDecimal userUid) {
		return repository.findById(userUid);
	}
	@Override
	public int deleteUserMaster(BigDecimal userUid) {
		repository.deleteById(userUid);
		return 1;
	}
	@Override
	public UserMaster updateUserMaster(UserMaster userMaster) {
		repository.save(userMaster);
		return null;
	}
	@Override
	public UserMaster findByUserId(String userId) {
		// TODO Auto-generated method stub
		return repository.findByUserId(userId);
	}
	@Override
	public UserMaster findByUserName(String userName) {
		// TODO Auto-generated method stub
		return repository.findByUserName(userName);
	}
	@Override
	public void saveUserMasterList(List<UserMaster> userMasterList) {
		
		userMasterList.forEach(userMaster->{
			 repository.save(userMaster);

		});

	}

}
