package com.webkryptominds.webservicetask.modules.security.modules.rolemaster;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class RoleMasterService implements RoleMasterBOInterface {
	@Autowired
	private RoleMasterRepository repository;

	public RoleMasterService() {
	}

	@Override
	public List<RoleMaster> getRoleMasterList() {
		return (List<RoleMaster>) repository.findAll();
	}

	@Override
	public RoleMaster saveRoleMaster(RoleMaster roleMaster) {
		repository.save(roleMaster);
		return roleMaster;
	}

	@Override
	public Optional<RoleMaster> searchRoleMaster(BigDecimal userRoleUid) {
		return repository.findById(userRoleUid);
	}

	@Override
	public int deleteRoleMaster(BigDecimal userRoleUid) {
		repository.deleteById(userRoleUid);
		return 1;
	}

	@Override
	public RoleMaster updateRoleMaster(RoleMaster roleMaster) {
		repository.save(roleMaster);
		return null;
	}

	@Override
	public RoleMaster roleMasterByRoleId(String roleId) {
		return repository.findByRoleId(roleId);
	}

	@Override
	@Transactional
	public List<RoleMaster> saveAllRoleMaster(List<RoleMaster> roleMasterList) {
		// TODO Auto-generated method stub
		return (List<RoleMaster>) repository.saveAll(roleMasterList);
	}

}
