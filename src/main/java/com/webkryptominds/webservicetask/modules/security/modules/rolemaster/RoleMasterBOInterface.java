package com.webkryptominds.webservicetask.modules.security.modules.rolemaster;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;




public interface RoleMasterBOInterface {

	public List<RoleMaster> getRoleMasterList();
	public RoleMaster saveRoleMaster(RoleMaster roleMaster);
	public List<RoleMaster> saveAllRoleMaster(List<RoleMaster> roleMasterList);

	public Optional<RoleMaster> searchRoleMaster(BigDecimal userRoleUid);
	public int deleteRoleMaster(BigDecimal userRoleUid);
	public RoleMaster updateRoleMaster(RoleMaster roleMaster);
	public RoleMaster roleMasterByRoleId(String roleId);
}
