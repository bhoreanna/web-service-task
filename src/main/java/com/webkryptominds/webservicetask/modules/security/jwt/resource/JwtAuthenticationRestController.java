package com.webkryptominds.webservicetask.modules.security.jwt.resource;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webkryptominds.webservicetask.common.util.WebServiceConstent;
import com.webkryptominds.webservicetask.modules.security.jwt.JwtTokenUtil;
import com.webkryptominds.webservicetask.modules.security.jwt.JwtUserDetails;
import com.webkryptominds.webservicetask.modules.security.modules.rolemaster.RoleMaster;
import com.webkryptominds.webservicetask.modules.security.modules.rolemaster.RoleMasterBOInterface;
import com.webkryptominds.webservicetask.modules.security.modules.usermaster.UserMaster;
import com.webkryptominds.webservicetask.modules.security.modules.usermaster.UserMasterBOInterface;


@RestController
@CrossOrigin(origins = WebServiceConstent.CROSS_ORIGIN_URL,allowedHeaders = "*")

//@CrossOrigin(origins = "http://192.168.10.162:4200", allowedHeaders = "*")

public class JwtAuthenticationRestController {

	@Value("${jwt.http.request.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;
	@Autowired
	private UserMasterBOInterface userMasterService;
	
	@Autowired
	private RoleMasterBOInterface roleMasterService;

	@RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest)
			throws AuthenticationException {
		System.out.println("*********** JwtAuthenticationRestController *************");
		System.out.println("User Name: "+authenticationRequest.getUsername());
		System.out.println("Password: "+authenticationRequest.getPassword());

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
		UserMaster user1 = userMasterService.findByUserName(authenticationRequest.getUsername());

		
		System.out.println("-----------------Role ----------------------");
		System.out.println("user Role Id: : "+ user1.getRoleMaster().getRoleId());
		
		final String roleId = user1.getRoleMaster().getRoleId();
		
		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtTokenResponse(token,roleId));
	}

	@RequestMapping(value = "${jwt.refresh.token.uri}", method = RequestMethod.GET)
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
		String authToken = request.getHeader(tokenHeader);
		final String token = authToken.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		JwtUserDetails user = (JwtUserDetails) jwtInMemoryUserDetailsService.loadUserByUsername(username);
		System.out.println("-----------------Role ----------------------");
		System.out.println("user Role Id: : "+ user.getAuthorities().toString());
		
		
		
		
		UserMaster user1 = userMasterService.findByUserName(username);

		
		System.out.println("-----------------Role ----------------------");
		System.out.println("user Role Id: : "+ user1.getRoleMaster().getRoleId());
		
		final String roleId = user1.getRoleMaster().getRoleId();
		
		
		
		
		
		if (jwtTokenUtil.canTokenBeRefreshed(token)) {
			String refreshedToken = jwtTokenUtil.refreshToken(token);
			return ResponseEntity.ok(new JwtTokenResponse(refreshedToken,roleId));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	
	@PostMapping("/signup")
	public ResponseEntity<UserMaster> signUpUserMaster(@RequestBody UserMaster userMaster) {
		
		System.out.println("userMaster: " + userMaster.getUserId());
		
		userMasterService.saveUserMaster(userMaster);
		
		return  ResponseEntity.ok(userMaster);
	}
	
	
	@GetMapping("/all-role-masters")
	public ResponseEntity<List<RoleMaster>> getAllRoleMaster() {
		
		System.out.println("getAllRoleMaster: " );
		List<RoleMaster> list = roleMasterService.getRoleMasterList();
		
		return  ResponseEntity.ok(list );
	}
	
	
	@ExceptionHandler({ AuthenticationException.class })
	public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}

	private void authenticate(String username, String password) {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new AuthenticationException("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new AuthenticationException("INVALID_CREDENTIALS", e);
		}
	}
}
