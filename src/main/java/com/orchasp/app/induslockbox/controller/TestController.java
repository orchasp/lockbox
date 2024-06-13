package com.orchasp.app.induslockbox.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@GetMapping("/user/home")
//	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<?> userTest() {
		return ResponseEntity.ok("user home");
	}

	@GetMapping("/admin/home")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> adminTest() {
		return ResponseEntity.ok("admin home");
	}
}
