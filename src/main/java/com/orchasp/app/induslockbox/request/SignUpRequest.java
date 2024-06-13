package com.orchasp.app.induslockbox.request;

import com.orchasp.app.induslockbox.entity.Role;

import lombok.Data;

@Data
public class SignUpRequest {
	private String userName;
	private String email;
	private String password;
	private String mobile;
	private Role role;
	
	
}
