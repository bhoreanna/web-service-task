package com.webkryptominds.webservicetask.modules.security.jwt.resource;

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {

	private static final long serialVersionUID = 8317676219297719109L;

	private final String token;
	private final String roleId;

	public JwtTokenResponse(String token, String roleId) {
		this.token = token;
		this. roleId = roleId;
		
	}

	public String getToken() {
		return this.token;
	}

	public String getRoleId() {
		return roleId;
	}



	
	
}