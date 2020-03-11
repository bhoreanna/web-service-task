package com.webkryptominds.webservicetask.modules.security.modules.rolemaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webkryptominds.webservicetask.common.util.WebServiceConstent;



@RestController
//@CrossOrigin(origins = "http://192.168.10.162:4200", allowedHeaders = "*")
@CrossOrigin(origins = WebServiceConstent.CROSS_ORIGIN_URL,allowedHeaders = "*")

@RequestMapping(value = "/security")
public class RoleMasterController {
	
	@Autowired
	private RoleMasterBOInterface roleMasterService;
	

	
	
	public RoleMasterController() {
		
	}
	
	//http://localhost:4200/roleMaster/roleMasterList
	
	@GetMapping("/roleMasters")
	public List<RoleMaster> roleMasterList() {
		System.out.println("i am in roleMasterList in main Controllar");
		List<RoleMaster> roleMasterList = roleMasterService.getRoleMasterList();
		System.out.println("roleMasterList List Size in Controller: " + roleMasterList.size());
		

		return roleMasterList;
	}
	
	//  roleMaster/roleMasterByRoleId/{roleId}
	
	@GetMapping("/roleMasters/{roleId}")
	public RoleMaster roleMasterByRoleId(@PathVariable String roleId) {

		System.out.println("roleId: " + roleId);
		RoleMaster roleMaster = roleMasterService.roleMasterByRoleId(roleId);
		System.out.println("roleMaster: " + roleMaster.getRoleId());
		


		return roleMaster
				;
	}
	
	@PostMapping( "/roleMasters")
	public List<RoleMaster> saveUserMasterList(@RequestBody List<RoleMaster> roleMasterList) {

		System.out.println("===============================================");
		System.out.println("roleMasterList: "+ roleMasterList.size());
		//userMasterService.saveUserMasterList( userMasterList);


		return roleMasterService.saveAllRoleMaster(roleMasterList);
	}

	
	@PostMapping("/roleMasters-single")
	public boolean saveRoleMaster(@RequestBody RoleMaster roleMaster) {
		
		
		System.out.println("roleMaster Id: " + roleMaster.getRoleId());
		
	
		roleMasterService.saveRoleMaster(roleMaster);



		return true;
	}
	
	


}
