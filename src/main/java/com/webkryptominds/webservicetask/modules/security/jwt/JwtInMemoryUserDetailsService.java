package com.webkryptominds.webservicetask.modules.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webkryptominds.webservicetask.modules.security.modules.usermaster.UserMaster;
import com.webkryptominds.webservicetask.modules.security.modules.usermaster.UserMasterBOInterface;





@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
	
	
	@Autowired
	private UserMasterBOInterface userMasterService;

	static {
		System.out.println("----------Static Block For ---------");
		inMemoryUserList.add(new JwtUserDetails(1L, "annabhore",
				"$2a$10$/EqxW.lSxTQcYo/Jj2WhWOCD6GWgCWCYFCcASSI6kfEcL3Do/077i", "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(2L, "ranga",
				"$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm", "ROLE_USER_2"));
		
		//$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm
		System.out.println("inMemoryUserList: "+inMemoryUserList);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtUserDetails findFirst1 =null;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("username name in loadUserByUsername: "+username);
//		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
//				.filter(user -> user.getUsername().equals(username)).findFirst();
		
		UserMaster user1 = userMasterService.findByUserName(username);
		System.out.println("User From DB: " + user1.getUserName());
		
		System.out.println("Role Id In JWTMemoryService: " + user1.getRoleMaster().getRoleId());

		
		
		
		String encodedString = encoder.encode(user1.getPassword());
		System.out.println("encodedString: " + encodedString);
		
		 findFirst1 = new JwtUserDetails(1L,user1.getUserName(),encodedString,user1.getRoleMaster().getRoleId());
		 System.out.println("Before return  findFirst1: " + findFirst1);
		 return findFirst1;
		 
		 

	}

}
