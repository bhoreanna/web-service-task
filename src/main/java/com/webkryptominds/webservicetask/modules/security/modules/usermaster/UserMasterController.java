package com.webkryptominds.webservicetask.modules.security.modules.usermaster;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webkryptominds.webservicetask.common.util.WebServiceConstent;


@CrossOrigin(origins = WebServiceConstent.CROSS_ORIGIN_URL,allowedHeaders = "*")
@RestController
@RequestMapping("/security")
public class UserMasterController {

	@Autowired
	private UserMasterBOInterface userMasterService;

	public UserMasterController() {
	}	
	
	
	@GetMapping("/userMasters")
	public List<UserMaster> userMasterList() {
			System.out.println("Fetching usermaster list");

		List<UserMaster> userMasterList = userMasterService.getUserMasterList();

		System.out.println("userMasterList Size: " + userMasterList.size());


		 return userMasterList;
	}

	@GetMapping("/userMasters/{userUid}")
	public UserMaster getUserMaste(@PathVariable BigDecimal userUid) {

		UserMaster userMaster1 = userMasterService.searchUserMaster(userUid).get();
		System.out.println("UserName: " + userMaster1.getUserName());



		return userMaster1;
	}

	@RequestMapping(value = "/userMasterByUserId/{userId}")
	public UserMaster getUserMasterById(@PathVariable String userId) {

		System.out.println("userId: " + userId);
		UserMaster userMaster1 = userMasterService.findByUserId(userId);
		System.out.println("UserName: " + userMaster1.getUserName());
		


		return userMaster1;
	}

	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@RequestMapping(value = "/loginUserMaster", method = RequestMethod.POST)
	public UserMaster loginUserMaster(@RequestBody UserMaster userMaster) {
		System.out.println("<--Login User -->" );
		System.out.println("UserName: " + userMaster.getUserId());
		System.out.println("Password: " + userMaster.getPassword() != null ? userMaster.getPassword() : "null");
		UserMaster userMaster1 = userMasterService.findByUserId(userMaster.getUserId());
		
		System.out.println("userMaster1: " + userMaster1.getUserUid());
		return userMaster1;
	}

	

	@RequestMapping(value = "/saveUserMaster", method = RequestMethod.POST)
	public boolean saveUserMaster(@RequestBody UserMaster userMaster) {

		System.out.println("user Name: "+ userMaster.getUserName());
		System.out.println("Role Name: "+ userMaster.getRoleMaster().getRoleName());

		userMasterService.saveUserMaster(userMaster);


		return true;
	}
	
	@RequestMapping(value = "/saveUserMasterList", method = RequestMethod.POST)
	public boolean saveUserMasterList(@RequestBody List<UserMaster> userMasterList) {

		System.out.println("===============================================");
		System.out.println("userMasterList: "+ userMasterList.size());

		userMasterService.saveUserMasterList( userMasterList);


		return true;
	}
	
	
	
	

}
