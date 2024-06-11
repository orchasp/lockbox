package com.orchasp.app.induslockbox.request;

import com.orchasp.app.induslockbox.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpRequest {
	private String userName;
	private String email;
	private String password;
	private Role role;
	
	
}
