
package com.orchasp.app.induslockbox.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Admin;
import com.orchasp.app.induslockbox.repository.AdminRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {
	@Autowired
	private final AdminRepository repository;
	
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			
			@Override
			 public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		        Admin admin = repository.findByEmail(email)
		                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
		        return new org.springframework.security.core.userdetails.User(admin.getEmail(), admin.getPassword(), new ArrayList<>());
		    }
		};
	}

}
//=======
//package com.orchasp.app.induslockbox.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.orchasp.app.induslockbox.entity.Admin;
//import com.orchasp.app.induslockbox.entity.Role;
//import com.orchasp.app.induslockbox.repository.AdminRepository;
//import com.orchasp.app.induslockbox.request.SignUpRequest;
//import com.orchasp.app.induslockbox.response.MessageResponse;
//
//@Service
//public class AdminService {
//	@Autowired
//	private AdminRepository adminRepository;
//	@Autowired
//	private PasswordEncoder encoder;
//
//	public ResponseEntity<?> signup(SignUpRequest request) {
//		if(adminRepository.existsByUserName(request.getUserName())) {
//			return ResponseEntity
//					.badRequest()
//					.body(new MessageResponse("Error: Username is already taken!"));
//		}
//		
//		if(adminRepository.existsByEmail(request.getEmail())) {
//			return ResponseEntity
//					.badRequest()
//					.body(new MessageResponse("Error: Email is already taken!"));
//		}
//		
//		Admin admin=new Admin(request.getUserName(),
//				request.getEmail(),
//				encoder.encode(request.getPassword()),
//				Role.USER);
//		return null;
//	}
//}
//>>>>>>> a4d339648c37e7efce53273319f4159d3f544dad
